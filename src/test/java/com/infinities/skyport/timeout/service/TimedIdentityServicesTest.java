package com.infinities.skyport.timeout.service;

import java.util.concurrent.ExecutorService;

import org.dasein.cloud.identity.IdentityAndAccessSupport;
import org.dasein.cloud.identity.IdentityServices;
import org.dasein.cloud.identity.ShellKeySupport;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.IdentityConfiguration;


public class TimedIdentityServicesTest {
	
	protected Mockery context = new JUnit4Mockery() {
		
		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	
	private ExecutorService executorService;
	private IdentityConfiguration identityConfiguration;
	private IdentityServices identityServices;
	
	private IdentityAndAccessSupport identityAndAccessSupport;
	private ShellKeySupport shellKeySupport;
	
	@Before
	public void setUp() {
		identityServices = context.mock(IdentityServices.class);
		executorService = context.mock(ExecutorService.class);
		identityConfiguration = new IdentityConfiguration();
		
		identityAndAccessSupport = context.mock(IdentityAndAccessSupport.class);
		shellKeySupport = context.mock(ShellKeySupport.class);
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testTimedIdentityServices() throws InitializationException {
		context.checking(new Expectations() {
			{
				exactly(1).of(identityServices).getIdentityAndAccessSupport();
				will(returnValue(identityAndAccessSupport));
				exactly(1).of(identityServices).getShellKeySupport();
				will(returnValue(shellKeySupport));
			}
		});
		new TimedIdentityServices(identityServices, identityConfiguration, executorService);
	}
}
