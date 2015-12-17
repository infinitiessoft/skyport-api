package com.infinities.skyport.async.service.admin;

import java.util.Locale;

import javax.annotation.Nonnull;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.admin.Offering;
import org.dasein.cloud.admin.Prepayment;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncPrepaymentSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("PPM:ANY");

	static public final ServiceAction GET_OFFERING = new ServiceAction("PPM:GET_OFFERING");
	static public final ServiceAction GET_PREPAYMENT = new ServiceAction("PPM:GET_PREPAYMENT");
	static public final ServiceAction LIST_OFFERING = new ServiceAction("PPM:READ_OFFERING");
	static public final ServiceAction LIST_PREPAYMENT = new ServiceAction("PPM:READ_PREPAYMENT");
	static public final ServiceAction PREPAY = new ServiceAction("PPM:PREPAY");


	public AsyncResult<Offering> getOffering(String offeringId) throws InternalException, CloudException;

	public AsyncResult<Prepayment> getPrepayment(String prepaymentId) throws InternalException, CloudException;

	public AsyncResult<String> getProviderTermForOffering(Locale locale);

	public AsyncResult<String> getProviderTermForPrepayment(Locale locale);

	public boolean isSubscribed() throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<Offering>> listOfferings() throws InternalException, CloudException;

	public @Nonnull AsyncResult<Iterable<Prepayment>> listPrepayments() throws InternalException, CloudException;

	public AsyncResult<String> prepay(String offeringId, int count) throws InternalException, CloudException;

}
