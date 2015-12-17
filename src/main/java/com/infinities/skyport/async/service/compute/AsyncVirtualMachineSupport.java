package com.infinities.skyport.async.service.compute;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.OperationNotSupportedException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.compute.SpotPriceHistory;
import org.dasein.cloud.compute.SpotPriceHistoryFilterOptions;
import org.dasein.cloud.compute.SpotVirtualMachineRequest;
import org.dasein.cloud.compute.SpotVirtualMachineRequestCreateOptions;
import org.dasein.cloud.compute.SpotVirtualMachineRequestFilterOptions;
import org.dasein.cloud.compute.VMFilterOptions;
import org.dasein.cloud.compute.VMLaunchOptions;
import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.VirtualMachineCapabilities;
import org.dasein.cloud.compute.VirtualMachineProduct;
import org.dasein.cloud.compute.VirtualMachineProductFilterOptions;
import org.dasein.cloud.compute.VirtualMachineStatus;
import org.dasein.cloud.compute.VirtualMachineSupport;
import org.dasein.cloud.compute.VmState;
import org.dasein.cloud.compute.VmStatistics;
import org.dasein.cloud.compute.VmStatusFilterOptions;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncVirtualMachineSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("VM:ANY");

	static public final ServiceAction BOOT = new ServiceAction("VM:BOOT");
	static public final ServiceAction CLONE = new ServiceAction("VM:CLONE");
	static public final ServiceAction CREATE_VM = new ServiceAction("VM:CREATE_VM");
	static public final ServiceAction GET_VM = new ServiceAction("VM:GET_VM");
	static public final ServiceAction LIST_VM = new ServiceAction("VM:LIST_VM");
	static public final ServiceAction PAUSE = new ServiceAction("VM:PAUSE");
	static public final ServiceAction REBOOT = new ServiceAction("VM:REBOOT");
	static public final ServiceAction REMOVE_VM = new ServiceAction("VM:REMOVE_VM");
	static public final ServiceAction TOGGLE_ANALYTICS = new ServiceAction("VM:TOGGLE_ANALYTICS");
	static public final ServiceAction VIEW_ANALYTICS = new ServiceAction("VM:VIEW_ANALYTICS");
	static public final ServiceAction VIEW_CONSOLE = new ServiceAction("VM:VIEW_CONSOLE");


	/**
	 * Changes the VirtualMachineProduct for clouds that allow the operation.
	 * This method is intended for use in clouds with distinct, named products.
	 *
	 * @param virtualMachineId
	 *            the virtual machine being altered
	 * @param productId
	 *            the Id of the new product
	 * @return the modified VirtualMachine object
	 * @throws InternalException
	 *             an internal error occurred processing the request
	 * @throws CloudException
	 *             an error occurred in the cloud processing the request
	 */
	public @Nonnull AsyncResult<VirtualMachine> alterVirtualMachineProduct(@Nonnull String virtualMachineId,
			@Nonnull String productId) throws InternalException, CloudException;

	/**
	 * Changes the VirtualMachineProduct for clouds that allow the operation.
	 * This method is intended for use in clouds with contiguous, non-named
	 * products.
	 *
	 * @param virtualMachineId
	 *            the virtual machine being altered
	 * @param cpuCount
	 *            the new cpu count or null if cpus are not being altered
	 * @param ramInMB
	 *            the new ram size or null if ram is not being altered
	 * @return the modified VirtualMachine object
	 * @throws InternalException
	 *             an internal error occurred processing the request
	 * @throws CloudException
	 *             an error occurred in the cloud processing the request
	 */
	public @Nonnull AsyncResult<VirtualMachine> alterVirtualMachineSize(@Nonnull String virtualMachineId,
			@Nullable String cpuCount, @Nullable String ramInMB) throws InternalException, CloudException;

	/**
	 * Changes the firewalls currently associated with the Virtual Machine. The
	 * method will attempt to match the firewalls in the specified array so
	 * needs to include existing as well as changing firewalls
	 *
	 * @param virtualMachineId
	 *            the virtual machine being altered
	 * @param firewalls
	 *            the array of firewall IDs to be associated with the VM
	 * @return the modified VirtualMachine object
	 * @throws InternalException
	 *             an internal error occurred processing the request
	 * @throws CloudException
	 *             an error occurred in the cloud processing the request
	 */
	public @Nonnull AsyncResult<VirtualMachine> alterVirtualMachineFirewalls(@Nonnull String virtualMachineId,
			@Nonnull String[] firewalls) throws InternalException, CloudException;

	/**
	 * Cancels the data feed for Spot VMs
	 *
	 * @throws CloudException
	 *             an error occurred in the cloud processing the request
	 * @throws InternalException
	 *             an internal error occurred processing the request
	 */
	public AsyncResult<Void> cancelSpotDataFeedSubscription() throws CloudException, InternalException;

	/**
	 * Cancels and removes a request for Spot VMs
	 *
	 * @param providerSpotVirtualMachineRequestID
	 *            the ID of the SpotVirtualMachineRequest to be cancelled
	 * @throws CloudException
	 *             an error occurred in the cloud processing the request
	 * @throws InternalException
	 *             an internal error occurred processing the request
	 */
	public AsyncResult<Void> cancelSpotVirtualMachineRequest(@Nonnull String providerSpotVirtualMachineRequestID)
			throws CloudException, InternalException;

	/**
	 * Clones an existing virtual machine into a new copy.
	 *
	 * @param vmId
	 *            the ID of the server to be cloned
	 * @param intoDcId
	 *            the ID of the data center in which the new server will operate
	 * @param name
	 *            the name of the new server
	 * @param description
	 *            a description for the new server
	 * @param powerOn
	 *            power on the new server
	 * @param firewallIds
	 *            a list of firewall IDs to protect the new server
	 * @return a newly deployed server cloned from the original
	 * @throws InternalException
	 *             an internal error occurred processing the request
	 * @throws CloudException
	 *             an error occurred in the cloud processing the request
	 */
	public @Nonnull AsyncResult<VirtualMachine> clone(@Nonnull String vmId, @Nonnull String intoDcId, @Nonnull String name,
			@Nonnull String description, boolean powerOn, @Nullable String... firewallIds) throws InternalException,
			CloudException;

	/**
	 * Creates a SpotVirtualMachineRequest fitting the options specified in the
	 * SpotVirtualMachineRequestCreateOptions
	 *
	 * @param options
	 *            the configuration options for the spot VM request
	 * @return a newly created SpotVirtualMachineRequest
	 * @throws CloudException
	 *             an error occurred in the cloud processing the request
	 * @throws InternalException
	 *             an internal error occurred processing the request
	 */
	public @Nonnull AsyncResult<SpotVirtualMachineRequest> createSpotVirtualMachineRequest(
			@Nonnull SpotVirtualMachineRequestCreateOptions options) throws CloudException, InternalException;

	/**
	 * Turns extended analytics off for the target server. If the underlying
	 * cloud does not support hypervisor monitoring, this method will be a
	 * NO-OP.
	 *
	 * @param vmId
	 *            the provider ID for the server to stop monitoring
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public AsyncResult<Void> disableAnalytics(@Nonnull String vmId) throws InternalException, CloudException;

	/**
	 * Turns extended hypervisor analytics for the target server. If the
	 * underlying cloud does not support extended analytics, this method will be
	 * a NO-OP.
	 *
	 * @param vmId
	 *            the provider ID for the server to start monitoring
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public AsyncResult<Void> enableAnalytics(@Nonnull String vmId) throws InternalException, CloudException;

	/**
	 * Creates the datafeed for Spot VMs, enabling you to view Spot VMs usage
	 * logs.
	 *
	 * @param bucketName
	 *            the object storage bucket to which the logs will be written
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> enableSpotDataFeedSubscription(@Nonnull String bucketName) throws CloudException,
			InternalException;

	/**
	 * Provides access to meta-data about virtual machine capabilities in the
	 * current region of this cloud.
	 *
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull VirtualMachineCapabilities getCapabilities() throws InternalException, CloudException;

	/**
	 * Provides the password as stored by the cloud provider (sometimes
	 * encrypted)
	 *
	 * @param vmId
	 *            the unique ID of the target server
	 * @return the current password of the virtual machine as stored by the
	 *         provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nullable AsyncResult<String> getPassword(@Nonnull String vmId) throws InternalException, CloudException;

	/**
	 * Provides the userData as stored by the cloud provider (encrypted)
	 *
	 * @param vmId
	 *            the unique ID of the target server
	 * @return the current userData of the virtual machine as stored by the
	 *         provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nullable AsyncResult<String> getUserData(@Nonnull String vmId) throws InternalException, CloudException;

	/**
	 * Provides all output from the console of the target server since the
	 * specified Unix time.
	 *
	 * @param vmId
	 *            the unique ID of the target server
	 * @return the current output from the server console
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull AsyncResult<String> getConsoleOutput(@Nonnull String vmId) throws InternalException, CloudException;

	/**
	 * Fetches the VM product associated with a specific product ID.
	 *
	 * @param productId
	 *            the virtual machine product ID (flavor, size, etc.)
	 * @return the product represented by the specified product ID
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             fetching the product
	 * @throws CloudException
	 *             an error occurred fetching the product from the cloud
	 */
	public @Nullable AsyncResult<VirtualMachineProduct> getProduct(@Nonnull String productId) throws InternalException,
			CloudException;

	/**
	 * Provides the data from a specific virtual machine.
	 *
	 * @param vmId
	 *            the provider ID for the desired server
	 * @return the data behind the target server
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nullable AsyncResult<VirtualMachine> getVirtualMachine(@Nonnull String vmId) throws InternalException,
			CloudException;

	/**
	 * Provides hypervisor statistics for the specified server that fit within
	 * the defined time range. For clouds that do not provide hypervisor
	 * statistics, this method should return an empty {@link VmStatistics}
	 * object and NOT <code>null</code>.
	 *
	 * @param vmId
	 *            the unique ID for the target server
	 * @param from
	 *            the beginning of the timeframe for which you want statistics
	 * @param to
	 *            the end of the timeframe for which you want statistics
	 * @return the statistics for the target server
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull AsyncResult<VmStatistics> getVMStatistics(@Nonnull String vmId, @Nonnegative long from,
			@Nonnegative long to) throws InternalException, CloudException;

	/**
	 * Provides hypervisor statistics for the specified server that fit within
	 * the defined time range. For clouds that do not provide hypervisor
	 * statistics, this method should return an empty list.
	 *
	 * @param vmId
	 *            the unique ID for the target server
	 * @param from
	 *            the beginning of the timeframe for which you want statistics
	 * @param to
	 *            the end of the timeframe for which you want statistics
	 * @return a collection of discreet server statistics over the specified
	 *         period
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<VmStatistics>> getVMStatisticsForPeriod(@Nonnull String vmId,
			@Nonnegative long from, @Nonnegative long to) throws InternalException, CloudException;

	/**
	 * Provides the status as determined by the cloud provider
	 *
	 * @param vmIds
	 *            the unique ID(s) of the target server(s)
	 * @return the status(es) of the virtual machines
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nullable AsyncResult<Iterable<VirtualMachineStatus>> getVMStatus(@Nullable String... vmIds)
			throws InternalException, CloudException;

/**
     * Lists all virtual machines status(es) matching the given {@link VmStatusFilterOptions) belonging to the account owner
     * currently in the cloud. The filtering functionality is delegated to the cloud provider.
     *
     * @param filterOptions filter options
     * @return the status(es) of the virtual machines
     * @throws InternalException an error occurred within the Dasein Cloud API implementation
     * @throws CloudException    an error occurred within the cloud provider
     */
	public @Nullable AsyncResult<Iterable<VirtualMachineStatus>> getVMStatus(@Nullable VmStatusFilterOptions filterOptions)
			throws InternalException, CloudException;

	/**
	 * Indicates whether this account is subscribed to using virtual machines.
	 *
	 * @return true if the subscription is valid for using virtual machines
	 * @throws CloudException
	 *             an error occurred querying the cloud for subscription info
	 * @throws InternalException
	 *             an error occurred within the implementation determining
	 *             subscription state
	 */
	public boolean isSubscribed() throws CloudException, InternalException;

	/**
	 * Preferred mechanism for launching a virtual machine in the cloud. This
	 * method accepts a rich set of launch configuration options that define
	 * what the virtual machine should look like once launched. These options
	 * may include things that behave very differently in some clouds. It is
	 * expected that the method will return immediately once Dasein Cloud as a
	 * trackable server ID, even if it has to spawn off a background thread to
	 * complete follow on tasks (such as provisioning and attaching volumes).
	 *
	 * @param withLaunchOptions
	 *            the launch options to use in creating a new virtual machine
	 * @return the newly created virtual machine
	 * @throws CloudException
	 *             the cloud provider errored out when launching the virtual
	 *             machine
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public @Nonnull AsyncResult<VirtualMachine> launch(@Nonnull VMLaunchOptions withLaunchOptions) throws CloudException,
			InternalException;

	/**
	 * Launches multiple virtual machines based on the same set of launch
	 * options. In clouds that support launching many VMs in a single request,
	 * it will perform this operation as a single request. In other VMs,
	 * however, it may perform this as parallel calls to
	 * {@link #launch(VMLaunchOptions)}. In the event of parallel launches, this
	 * method is considered a success as long as just one virtual machine
	 * launches. Thus an error is thrown only if no virtual machines were
	 * provisioned.
	 *
	 * @param withLaunchOptions
	 *            the launch options that define how the virtual machines will
	 *            be configured
	 * @param count
	 *            the number of virtual machines to launch
	 * @return a list of virtual machines successfully launched (the number
	 *         launched may not match the requested number)
	 * @throws CloudException
	 *             the cloud provider failed to provision ANY virtual machines
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 *             (virtual machines may have been provisioned)
	 */
	public @Nonnull AsyncResult<Iterable<String>> launchMany(@Nonnull VMLaunchOptions withLaunchOptions,
			@Nonnegative int count) throws CloudException, InternalException;

	/**
	 * Provides a list of firewalls protecting the specified server. If
	 * firewalls are not supported in this cloud, the list will be empty.
	 *
	 * @param vmId
	 *            the server ID whose firewall list is being sought
	 * @return the list of firewalls protecting the target server
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<String>> listFirewalls(@Nonnull String vmId) throws InternalException,
			CloudException;

	/**
	 * Provides a list of instance types, service offerings, or server sizes
	 * (however the underlying cloud might describe it) compatible with
	 * particular machine image
	 *
	 * @param machineImageId
	 *            the desire machine image to match with
	 * @return the list of server sizes available for the specified machine
	 *         image
	 * @throws InternalException
	 * @throws CloudException
	 */
	public @Nonnull AsyncResult<Iterable<VirtualMachineProduct>> listProducts(@Nonnull String machineImageId)
			throws InternalException, CloudException;

	/**
	 * Provides a list of instance types, service offerings, or server sizes
	 * (however the underlying cloud might describe it) compatible with
	 * particular machine image
	 * 
	 * @param machineImageId
	 *            the desire machine image to match with
	 * @param options
	 *            the filter options
	 * @return
	 * @throws InternalException
	 * @throws CloudException
	 */
	public @Nonnull AsyncResult<Iterable<VirtualMachineProduct>> listProducts(@Nonnull String machineImageId,
			@Nonnull VirtualMachineProductFilterOptions options) throws InternalException, CloudException;

	/**
	 * Lists all virtual machine products matching the given
	 * VirtualMachineProductFilterOptions belonging to the account owner
	 * currently in the cloud. The filtering functionality is delegated to the
	 * cloud provider.
	 *
	 * @param options
	 *            the filter options
	 * @return the list of server sizes available matching the filter
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<VirtualMachineProduct>> listProducts(
			@Nonnull VirtualMachineProductFilterOptions options) throws InternalException, CloudException;

	/**
	 * Provides a list of every product available to the cloud regardless of any
	 * filters or dependent machine images. Should not in any case be used to
	 * provide a product ID for use in a VM launch as they may not be compatible
	 * with the selected machine image
	 * 
	 * @return list of products available to the cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<VirtualMachineProduct>> listAllProducts() throws InternalException, CloudException;

	/**
	 * Provides a list of price history records for Spot VMs
	 *
	 * @param options
	 *            filter options
	 * @return all price history entries that match the specified filter
	 * @throws CloudException
	 * @throws InternalException
	 */
	public @Nonnull AsyncResult<Iterable<SpotPriceHistory>> listSpotPriceHistories(
			@Nullable SpotPriceHistoryFilterOptions options) throws CloudException, InternalException;

	/**
	 * Providers a list of spot VM requests
	 *
	 * @return all spot VM requests that match the specified filter
	 * @throws CloudException
	 * @throws InternalException
	 */
	public @Nonnull AsyncResult<Iterable<SpotVirtualMachineRequest>> listSpotVirtualMachineRequests(
			@Nullable SpotVirtualMachineRequestFilterOptions options) throws CloudException, InternalException;

	/**
	 * Lists the status for all virtual machines in the current region.
	 *
	 * @return the status for all virtual machines in the current region
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listVirtualMachineStatus() throws InternalException,
			CloudException;

	/**
	 * Lists all virtual machines belonging to the account owner currently in
	 * the cloud.
	 *
	 * @return all servers belonging to the account owner
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<VirtualMachine>> listVirtualMachines() throws InternalException, CloudException;

	/**
	 * Lists all virtual machines matching the given VMFilterOptions belonging
	 * to the account owner currently in the cloud. The filtering functionality
	 * is delegated to the cloud provider.
	 *
	 * @param options
	 *            filter options
	 * @return all servers belonging to the account owner
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<VirtualMachine>> listVirtualMachines(@Nullable VMFilterOptions options)
			throws InternalException, CloudException;

	/**
	 * Executes a hypervisor pause that essentially removes the virtual machine
	 * from the hypervisor scheduler. The virtual machine is considered active
	 * and volatile at this point, but it won't actually do anything from
	 * CPU-perspective until it is {@link #unpause(String)}'ed.
	 *
	 * @param vmId
	 *            the provider ID for the server to pause
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws OperationNotSupportedException
	 *             pausing is not supported for the specified virtual machine
	 * @see #unpause(String)
	 */
	public AsyncResult<Void> pause(@Nonnull String vmId) throws InternalException, CloudException;

	/**
	 * Executes a virtual machine reboot for the target virtual machine.
	 *
	 * @param vmId
	 *            the provider ID for the server to reboot
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public AsyncResult<Void> reboot(@Nonnull String vmId) throws CloudException, InternalException;

	/**
	 * Resumes a previously suspended virtual machine and returns it to an
	 * operational state ({@link VmState#RUNNING}).
	 *
	 * @param vmId
	 *            the virtual machine ID to be resumed
	 * @throws CloudException
	 *             an error occurred with the cloud provider in attempting to
	 *             resume the virtual machine
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the target virtual machine cannot be suspended/resumed
	 * @see #suspend(String)
	 */
	public AsyncResult<Void> resume(@Nonnull String vmId) throws CloudException, InternalException;

	/**
	 * Starts up a virtual machine that was previously stopped (or a VM that is
	 * created in a {@link VmState#STOPPED} state).
	 *
	 * @param vmId
	 *            the virtual machine to boot up
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws OperationNotSupportedException
	 *             starting/stopping is not supported for this virtual machine
	 * @see #stop(String)
	 */
	public AsyncResult<Void> start(@Nonnull String vmId) throws InternalException, CloudException;

	/**
	 * Shuts down a virtual machine with the capacity to boot it back up at a
	 * later time. The contents of volumes associated with this virtual machine
	 * are preserved, but the memory is not. This method should first attempt a
	 * nice shutdown, then force the shutdown.
	 *
	 * @param vmId
	 *            the virtual machine to be shut down
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws OperationNotSupportedException
	 *             starting/stopping is not supported for this virtual machine
	 * @see #start(String)
	 * @see #stop(String, boolean)
	 */
	public AsyncResult<Void> stop(@Nonnull String vmId) throws InternalException, CloudException;

	/**
	 * Shuts down a virtual machine with the capacity to boot it back up at a
	 * later time. The contents of volumes associated with this virtual machine
	 * are preserved, but the memory is not.
	 *
	 * @param vmId
	 *            the virtual machine to be shut down
	 * @param force
	 *            whether or not to force a shutdown (kill the power)
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws OperationNotSupportedException
	 *             starting/stopping is not supported for this virtual machine
	 * @see #start(String)
	 */
	public AsyncResult<Void> stop(@Nonnull String vmId, boolean force) throws InternalException, CloudException;

	/**
	 * Suspends a running virtual machine so that the memory is flushed to some
	 * kind of persistent storage for the purpose of later resuming the virtual
	 * machine in the exact same state.
	 *
	 * @param vmId
	 *            the unique ID of the virtual machine to be suspended
	 * @throws CloudException
	 *             an error occurred with the cloud provider suspending the
	 *             virtual machine
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             suspending is not supported for this virtual machine
	 * @see #resume(String)
	 */
	public AsyncResult<Void> suspend(@Nonnull String vmId) throws CloudException, InternalException;

	/**
	 * TERMINATES AND DESTROYS the specified virtual machine. If it is running,
	 * it will be stopped. Once it is stopped, all of its data will be destroyed
	 * and it will no longer be usable. This is a very dangerous operation,
	 * especially in clouds with persistent servers.
	 *
	 * @param vmId
	 *            the provider ID of the server to be destroyed
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public AsyncResult<Void> terminate(@Nonnull String vmId) throws InternalException, CloudException;

	/**
	 * TERMINATES AND DESTROYS the specified virtual machine. If it is running,
	 * it will be stopped. Once it is stopped, all of its data will be destroyed
	 * and it will no longer be usable. This is a very dangerous operation,
	 * especially in clouds with persistent servers.
	 *
	 * @param vmId
	 *            the provider ID of the server to be destroyed
	 * @param explanation
	 *            an optional explanation supplied to the cloud provider for
	 *            audit purposes describing why the VM was terminated
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public AsyncResult<Void> terminate(@Nonnull String vmId, @Nullable String explanation) throws InternalException,
			CloudException;

	/**
	 * Executes a hypervisor unpause operation on a currently paused virtual
	 * machine, adding it back into the hypervisor scheduler.
	 *
	 * @param vmId
	 *            the unique ID of the virtual machine to be unpaused
	 * @throws CloudException
	 *             an error occurred within the cloud provider while unpausing
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws OperationNotSupportedException
	 *             pausing/unpausing is not supported for the specified virtual
	 *             machine
	 * @see #pause(String)
	 */
	public AsyncResult<Void> unpause(@Nonnull String vmId) throws CloudException, InternalException;

	/**
	 * Updates meta-data for a virtual machine with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 *
	 * @param vmId
	 *            the virtual machine to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String vmId, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Updates meta-data for multiple virtual machines with the new values. It
	 * will not overwrite any value that currently exists unless it appears in
	 * the tags you submit.
	 *
	 * @param vmIds
	 *            the virtual machines to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String[] vmIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for a virtual machine. Remove any tags that were not
	 * provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param vmId
	 *            the virtual machine to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setTags(@Nonnull String vmId, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Set meta-data for multiple virtual machines. Remove any tags that were
	 * not provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param vmIds
	 *            the virtual machines to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setTags(@Nonnull String[] vmIds, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Removes meta-data from a virtual machine. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 *
	 * @param vmId
	 *            the virtual machine to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String vmId, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Removes meta-data from multiple virtual machines. If tag values are set,
	 * their removal is dependent on underlying cloud provider behavior. They
	 * may be removed only if the tag value matches or they may be removed
	 * regardless of the value.
	 *
	 * @param vmIds
	 *            the virtual machine to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String[] vmIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	VirtualMachineSupport getSupport();
}
