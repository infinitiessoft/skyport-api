/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.infinities.skyport.timeout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Invocation;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.action.CustomAction;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.util.concurrent.UncheckedTimeoutException;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.FunctionConfiguration;
import com.infinities.skyport.model.Time;

public class ServiceProviderTimeLimiterTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	private ExecutorService executor;
	private ServiceProviderTimeLimiter limiter;
	private Services services;
	private Configuration configuration;
	private FunctionConfiguration fc;


	@Before
	public void setUp() throws Exception {
		fc = new FunctionConfiguration();
		Time timeout = new Time();
		timeout.setNumber(1);
		timeout.setUnit(TimeUnit.SECONDS);
		fc.setTimeout(timeout);
		executor = Executors.newCachedThreadPool();
		limiter = new ServiceProviderTimeLimiter(executor);
		services = context.mock(Services.class);
		configuration = context.mock(Configuration.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewProxyExecute() throws InitializationException {
		fc.getTimeout().setNumber(0);
		context.checking(new Expectations() {

			{
				exactly(1).of(services).execute();
				will(new CustomAction("execute with no sleep") {

					@Override
					public Object invoke(Invocation invocation) throws Throwable {
						System.err.println("exeucte with no sleep");
						return null;
					}

				});

				exactly(1).of(configuration).getExecute();
				will(returnValue(fc));
			}
		});
		Services proxy = limiter.newProxy(services, Services.class, configuration);
		proxy.execute();

	}

	@Test
	public void testNewProxyExecuteWithZeroTimeout() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(services).execute();
				will(new CustomAction("execute with no sleep") {

					@Override
					public Object invoke(Invocation invocation) throws Throwable {
						System.err.println("exeucte with no sleep");
						return null;
					}

				});

				exactly(1).of(configuration).getExecute();
				will(returnValue(fc));
			}
		});
		Services proxy = limiter.newProxy(services, Services.class, configuration);
		proxy.execute();

	}

	@Test(expected = UncheckedTimeoutException.class)
	public void testNewProxyExecuteWithTimeout() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(services).execute();
				will(new CustomAction("execute with no sleep") {

					@Override
					public Object invoke(Invocation invocation) throws Throwable {
						Thread.sleep(2000l);
						System.err.println("exeucte with no sleep");
						return null;
					}

				});

				exactly(1).of(configuration).getExecute();
				will(returnValue(fc));
			}
		});
		Services proxy = limiter.newProxy(services, Services.class, configuration);
		proxy.execute();

	}

	@Test
	public void testNewProxyExecuteWithDeprecated() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(services).deprecated();
				will(new CustomAction("execute with no sleep") {

					@Override
					public Object invoke(Invocation invocation) throws Throwable {
						Thread.sleep(2000l);
						System.err.println("exeucte with no sleep");
						return null;
					}

				});

			}
		});
		Services proxy = limiter.newProxy(services, Services.class, configuration);
		proxy.deprecated();

	}

	@Test(expected = InitializationException.class)
	public void testNewProxyInitializationFail() throws InitializationException {
		Services proxy = limiter.newProxy(services, Services.class, new Object());
		proxy.execute();

	}


	private interface Services {

		void execute();

		@Deprecated
		void deprecated();

	}

	public interface Configuration {

		FunctionConfiguration getExecute();

	}

}
