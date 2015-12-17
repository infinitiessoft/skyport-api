package com.infinities.skyport.timeout.service;

import java.util.concurrent.ExecutorService;

import org.dasein.cloud.admin.AccountSupport;
import org.dasein.cloud.admin.AdminServices;
import org.dasein.cloud.admin.BillingSupport;
import org.dasein.cloud.admin.PrepaymentSupport;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.AdminConfiguration;

public class TimedAdminServicesTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	private ExecutorService executorService;
	private AdminConfiguration adminConfiguration;
	private AdminServices adminServices;

	private PrepaymentSupport prepaymentSupport;
	private AccountSupport accountSupport;
	private BillingSupport billingSupport;


	@Before
	public void setUp() throws Exception {
		adminServices = context.mock(AdminServices.class);
		executorService = context.mock(ExecutorService.class);
		adminConfiguration = new AdminConfiguration();

		prepaymentSupport = context.mock(PrepaymentSupport.class);
		accountSupport = context.mock(AccountSupport.class);
		billingSupport = context.mock(BillingSupport.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTimedAdminServices() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(adminServices).getPrepaymentSupport();
				will(returnValue(prepaymentSupport));
				exactly(1).of(adminServices).getAccountSupport();
				will(returnValue(accountSupport));
				exactly(1).of(adminServices).getBillingSupport();
				will(returnValue(billingSupport));

			}
		});
		new TimedAdminServices(adminServices, adminConfiguration, executorService);
	}

}
