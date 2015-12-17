package com.infinities.skyport.distributed.lock;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.locks.ReadWriteLock;

import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.distributed.lock.DistributedLockFactory;
import com.infinities.skyport.distributed.lock.DistributedLockUtils.LocalDistributedDataStructureFactory;

/**
 * @author vanessa.williams
 */
public class DistributedLockFactoryTest {

	@Before
	public void setUp() {
		this.lockFactory = new DistributedLockFactory(new LocalDistributedDataStructureFactory());
	}

	/**
	 * One lock per name per thread.
	 */
	@Test
	public void oneLockObjectPerNamePerThread() {
		ReadWriteLock lock1 = lockFactory.getReadWriteLock("testLock");
		ReadWriteLock lock2 = lockFactory.getReadWriteLock("testLock");
		assertTrue(lock1 == lock2);

		lock1.readLock().lock();
		try {
			lock2.readLock().lock();
			fail("Thread should throw IllegalThreadStateException");
		} catch (IllegalThreadStateException success) {
		} finally {
			lock1.readLock().unlock();
		}
	}

	/**
	 * Two factories return the same lock.
	 */
	@Test
	public void testMultipleFactories() {
		DistributedLockFactory lockFactory2 = new DistributedLockFactory(new LocalDistributedDataStructureFactory());

		ReadWriteLock lock1 = lockFactory.getReadWriteLock("testLock");
		ReadWriteLock lock2 = lockFactory2.getReadWriteLock("testLock");
		assertTrue(lock1 == lock2);
		lock1.readLock().lock();
		try {
			lock2.readLock().lock();
			fail("Thread should throw IllegalThreadStateException");
		} catch (IllegalThreadStateException success) {
		} finally {
			lock1.readLock().unlock();
		}
	}


	DistributedLockFactory lockFactory;
}
