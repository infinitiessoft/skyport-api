package com.infinities.skyport.timeout;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.PropertyUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.FunctionConfiguration;
import com.infinities.skyport.model.Time;

public class ServiceProviderTimeLimiter {

	private static final Set<String> IGNORED_SET;

	static {
		Set<String> ignored = new HashSet<String>();
		ignored.add("isSubscribed");
		ignored.add("getCapabilities");
		ignored.add("mapServiceAction");
		ignored.add("hasConvergedHttpLoadBalancerSupport");

		IGNORED_SET = Collections.unmodifiableSet(ignored);
	}
	private final TimeLimiter limiter;


	public ServiceProviderTimeLimiter(ExecutorService executor) {
		this.limiter = new SimpleTimeLimiter(executor);
	}

	public <T> T newProxy(final T target, Class<T> interfaceType, final Object configuration) throws InitializationException {
		if (target == null) {
			return target;
		}
		checkNotNull(interfaceType);
		checkNotNull(configuration);
		checkArgument(interfaceType.isInterface(), "interfaceType must be an interface type");

		checkMethodOwnFunctionConfiguration(interfaceType, configuration);

		final Set<Method> interruptibleMethods = findInterruptibleMethods(interfaceType);

		InvocationHandler handler = new InvocationHandler() {

			@Override
			public Object invoke(Object obj, final Method method, final Object[] args) throws Throwable {
				String methodName = method.getName();
				long timeoutDuration = 0;
				TimeUnit timeUnit = TimeUnit.SECONDS;
				try {
					FunctionConfiguration functionConfiguration =
							(FunctionConfiguration) PropertyUtils.getProperty(configuration, methodName);
					Time timeout = functionConfiguration.getTimeout();
					if (timeout != null) {
						timeoutDuration = timeout.getNumber();
						timeUnit = timeout.getUnit();
					}
				} catch (NoSuchMethodException | IllegalArgumentException e) {
					if (IGNORED_SET.contains(method.getName()) || method.getAnnotation(Deprecated.class) != null) {
						return method.invoke(target, args);
					}
					throwCause(e, false);
					throw new AssertionError("can't get here");
				} catch (InvocationTargetException e) {
					throwCause(e, false);
					throw new AssertionError("can't get here");
				}
				Callable<Object> callable = new Callable<Object>() {

					@Override
					public Object call() throws Exception {
						try {
							return method.invoke(target, args);
						} catch (InvocationTargetException e) {
							throwCause(e, false);
							throw new AssertionError("can't get here");
						}
					}
				};
				if (timeoutDuration > 0) {
					return limiter.callWithTimeout(callable, timeoutDuration, timeUnit,
							interruptibleMethods.contains(method));
				} else {
					// no timeout
					return method.invoke(target, args);
				}
			}
		};
		return newProxy(interfaceType, handler);
	}

	private <T> void checkMethodOwnFunctionConfiguration(Class<T> interfaceType, final Object configuration)
			throws InitializationException {
		Method[] methods = interfaceType.getMethods();
		for (Method method : methods) {
			if (IGNORED_SET.contains(method.getName())) {
				continue;
			}
			if (method.getAnnotation(Deprecated.class) != null) {
				continue;
			}
			try {
				Class<?> c = PropertyUtils.getPropertyType(configuration, method.getName());
				Preconditions.checkArgument(c == FunctionConfiguration.class);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | IllegalArgumentException e) {
				throw new InitializationException("FunctionConfiguration for '" + method.getName() + "' cannot be found");
			}
		}

	}

	private static Exception throwCause(Exception e, boolean combineStackTraces) throws Exception {
		Throwable cause = e.getCause();
		if (cause == null) {
			throw e;
		}
		if (combineStackTraces) {
			StackTraceElement[] combined =
					ObjectArrays.concat(cause.getStackTrace(), e.getStackTrace(), StackTraceElement.class);
			cause.setStackTrace(combined);
		}
		if (cause instanceof Exception) {
			throw (Exception) cause;
		}
		if (cause instanceof Error) {
			throw (Error) cause;
		}
		// The cause is a weird kind of Throwable, so throw the outer exception.
		throw e;
	}

	private static Set<Method> findInterruptibleMethods(Class<?> interfaceType) {
		Set<Method> set = Sets.newHashSet();
		for (Method m : interfaceType.getMethods()) {
			if (declaresInterruptedEx(m)) {
				set.add(m);
			}
		}
		return set;
	}

	private static boolean declaresInterruptedEx(Method method) {
		for (Class<?> exType : method.getExceptionTypes()) {
			// debate: == or isAssignableFrom?
			if (exType == InterruptedException.class) {
				return true;
			}
		}
		return false;
	}

	// TODO: replace with version in common.reflect if and when it's
	// open-sourced
	private static <T> T newProxy(Class<T> interfaceType, InvocationHandler handler) {
		Object object = Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class<?>[] { interfaceType }, handler);
		return interfaceType.cast(object);
	}
}
