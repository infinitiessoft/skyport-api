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
package com.infinities.skyport.distributed.lock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.distributed.DistributedDataStructureFactory;
import com.infinities.skyport.distributed.lock.DistributedLockFactory;
import com.infinities.skyport.distributed.lock.DistributedLockUtils;
import com.infinities.skyport.distributed.lock.DistributedReentrantReadWriteLock;

/**
 * @author vanessa.williams
 */
public class DistributedReentrantReadWriteLockTest extends DistributedLockUtils {

	@Before
	public void setUp() {
		grid = new LocalDistributedDataStructureFactory();
		lockFactory = new DistributedLockFactory(grid);
	}

	/**
	 * write-locking and read-locking an unlocked lock succeed
	 */
	@Test
	public void lockingUnlockedSucceeds() {
		PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		assertNotWriteLocked(lock);

		lock.writeLock().lock();
		assertWriteLockedByMe(lock);
		assertHoldCount(lock, 1);

		lock.writeLock().unlock();
		assertNotWriteLocked(lock);
		assertHoldCount(lock, 0);

		lock.readLock().lock();
		assertNotWriteLocked(lock);
		assertHoldCount(lock, 1);

		lock.readLock().unlock();
		assertNotWriteLocked(lock);
		assertHoldCount(lock, 0);
	}

	/**
	 * write-lockInterruptibly is interruptible
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testWriteLockInterruptibly_Interruptible() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");

		lock.writeLock().lock();
		Thread t = newStartedThread(new CheckedInterruptedRunnable() {

			public void realRun() throws InterruptedException {
				lock.writeLock().lockInterruptibly();
			}
		});

		waitForQueuedThread(lock, t);
		t.interrupt();
		awaitTermination(t);
		lock.writeLock().unlock();
	}

	/**
	 * read-lockInterruptibly is interruptible
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testReadLockInterruptibly_Interruptible() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");

		lock.writeLock().lock();
		Thread t = newStartedThread(new CheckedInterruptedRunnable() {

			public void realRun() throws InterruptedException {
				lock.readLock().lockInterruptibly();
			}
		});

		waitForQueuedThread(lock, t);
		t.interrupt();
		awaitTermination(t);
		lock.writeLock().unlock();
	}

	/**
	 * timed try read-lock is interruptible
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testTryReadLock_Interruptible() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");

		lock.writeLock().lock();
		Thread t = newStartedThread(new CheckedInterruptedRunnable() {

			public void realRun() throws InterruptedException {
				assertTrue(lock.readLock().tryLock(4 * LONG_DELAY_MS, TimeUnit.MILLISECONDS));
			}
		});

		waitForQueuedThread(lock, t);
		t.interrupt();
		awaitTermination(t);
		lock.writeLock().unlock();
	}

	/**
	 * timed try write-lock is interruptible
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testTryWriteLock_Interruptible() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");

		lock.writeLock().lock();
		Thread t = newStartedThread(new CheckedInterruptedRunnable() {

			public void realRun() throws InterruptedException {
				assertTrue(lock.writeLock().tryLock(4 * LONG_DELAY_MS, TimeUnit.MILLISECONDS));
			}
		});

		waitForQueuedThread(lock, t);
		t.interrupt();
		awaitTermination(t);
		lock.writeLock().unlock();
	}

	/**
	 * write-unlocking an unlocked lock throws IllegalMonitorStateException
	 */
	@Test(expected = IllegalMonitorStateException.class)
	public void testWriteLock_MSIE() {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		assertNotWriteLocked(lock);

		lock.writeLock().unlock();
	}

	/**
	 * read-unlocking an unlocked lock throws IllegalMonitorStateException
	 */
	@Test(expected = IllegalMonitorStateException.class)
	public void testReadLock_MSIE() {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		assertNotWriteLocked(lock);

		lock.readLock().unlock();
	}

	/**
	 * getWriteHoldCount returns number of recursive holds
	 */
	@Test
	public void testGetWriteHoldCount() {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		for (int i = 1; i <= SIZE; i++) {
			lock.writeLock().lock();
			assertEquals(i, lock.getWriteHoldCount());
		}
		for (int i = SIZE; i > 0; i--) {
			lock.writeLock().unlock();
			assertEquals(i - 1, lock.getWriteHoldCount());
		}
	}

	/**
	 * getReadHoldCount returns number of recursive holds
	 */
	@Test
	public void testGetReadHoldCount() {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		for (int i = 1; i <= SIZE; i++) {
			lock.readLock().lock();
			assertEquals(i, lock.getReadHoldCount());
		}
		for (int i = SIZE; i > 0; i--) {
			lock.readLock().unlock();
			assertEquals(i - 1, lock.getReadHoldCount());
		}
	}

	/**
	 * writelock.getHoldCount returns number of recursive holds
	 */
	@Test
	public void testGetHoldCount() {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		for (int i = 1; i <= SIZE; i++) {
			lock.writeLock().lock();
			assertEquals(i, ((DistributedReentrantReadWriteLock.WriteLock) lock.writeLock()).getHoldCount());
		}
		for (int i = SIZE; i > 0; i--) {
			lock.writeLock().unlock();
			assertEquals(i - 1, ((DistributedReentrantReadWriteLock.WriteLock) lock.writeLock()).getHoldCount());
		}
	}

	/**
	 * timed write-tryLock on an unlocked lock succeeds
	 */
	@Test
	public void testWriteTryLock() throws InterruptedException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		assertTrue(lock.writeLock().tryLock(2 * LONG_DELAY_MS, TimeUnit.MILLISECONDS));
		assertWriteLockedByMe(lock);
		assertTrue(lock.writeLock().tryLock(2 * LONG_DELAY_MS, TimeUnit.MILLISECONDS));
		assertWriteLockedByMe(lock);
		lock.writeLock().unlock();
		lock.writeLock().unlock();
	}

	/**
	 * timed write-tryLock fails if locked
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testWriteTryLockWhenLocked() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.writeLock().lock();
		Thread t = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				try {
					assertFalse(lock.writeLock().tryLock(2 * LONG_DELAY_MS, TimeUnit.MILLISECONDS));
				} catch (InterruptedException ignore) {
					Thread.currentThread().interrupt();
				}
			}
		});

		awaitTermination(t, 3 * LONG_DELAY_MS);
		lock.writeLock().unlock();
	}

	/**
	 * timed read-tryLock fails if locked
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testReadTryLockWhenLocked() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.writeLock().lock();
		Thread t = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				try {
					assertFalse(lock.readLock().tryLock(2 * LONG_DELAY_MS, TimeUnit.MILLISECONDS));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		awaitTermination(t, 3 * LONG_DELAY_MS);
		lock.writeLock().unlock();
	}

	/**
	 * Multiple threads can hold a read lock when not write-locked
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testMultipleReadLocks() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.readLock().lock();
		Thread t = newStartedThread(new CheckedRunnable() {

			public void realRun() throws InterruptedException {
				assertTrue(lock.readLock().tryLock(LONG_DELAY_MS, TimeUnit.MILLISECONDS));
				lock.readLock().unlock();
				assertTrue(lock.readLock().tryLock(LONG_DELAY_MS, TimeUnit.MILLISECONDS));
				lock.readLock().unlock();
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});

		awaitTermination(t, 3 * LONG_DELAY_MS);
		lock.readLock().unlock();
	}

	/**
	 * A writelock succeeds only after a reading thread unlocks
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testWriteAfterReadLock() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.readLock().lock();
		Thread t = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.writeLock().lock();
				assertEquals(0, lock.getReadHoldCount());
				lock.writeLock().unlock();
			}
		});
		waitForQueuedThread(lock, t);
		assertNotWriteLocked(lock);
		assertEquals(1, lock.getReadHoldCount());
		lock.readLock().unlock();
		assertEquals(0, lock.getReadHoldCount());
		awaitTermination(t);
		assertNotWriteLocked(lock);
	}

	/**
	 * A writelock succeeds only after reading threads unlock
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testWriteAfterMultipleReadLocks() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.readLock().lock();
		lock.readLock().lock();
		assertEquals(2, lock.getReadHoldCount());
		Thread t1 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.readLock().lock();
				assertEquals(1, lock.getReadHoldCount());
				lock.readLock().unlock();
			}
		});
		awaitTermination(t1);

		Thread t2 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.writeLock().lock();
				assertEquals(1, lock.getWriteHoldCount());
				lock.writeLock().unlock();
			}
		});
		waitForQueuedThread(lock, t2);
		assertNotWriteLocked(lock);
		assertEquals(2, lock.getReadHoldCount());
		lock.readLock().unlock();
		lock.readLock().unlock();
		assertEquals(0, lock.getReadHoldCount());
		awaitTermination(t2);
		assertNotWriteLocked(lock);
	}

	/**
	 * Readlocks succeed only after a writing thread unlocks
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testReadAfterWriteLock() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.writeLock().lock();
		Thread t1 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});
		Thread t2 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});

		waitForQueuedThread(lock, t1);
		waitForQueuedThread(lock, t2);
		lock.writeLock().unlock();
		awaitTermination(t1);
		awaitTermination(t2);
	}

	/**
	 * Read trylock succeeds if write locked by current thread
	 */
	@Test
	public void testReadHoldingWriteLock() throws InterruptedException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.writeLock().lock();
		assertTrue(lock.readLock().tryLock(LONG_DELAY_MS, TimeUnit.MILLISECONDS));
		lock.readLock().unlock();
		lock.writeLock().unlock();
	}

	/**
	 * Read lock succeeds if write locked by current thread even if other
	 * threads are waiting for readlock
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testReadHoldingWriteLock2() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.writeLock().lock();
		lock.readLock().lock();
		lock.readLock().unlock();

		Thread t1 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});
		Thread t2 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});

		waitForQueuedThread(lock, t1);
		waitForQueuedThread(lock, t2);
		assertWriteLockedByMe(lock);
		lock.readLock().lock();
		lock.readLock().unlock();
		lock.writeLock().unlock();
		awaitTermination(t1);
		awaitTermination(t2);
	}

	/**
	 * Read lock succeeds if write locked by current thread even if other
	 * threads are waiting for writelock
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testReadHoldingWriteLock3() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.writeLock().lock();
		lock.readLock().lock();
		lock.readLock().unlock();

		Thread t1 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.writeLock().lock();
				lock.writeLock().unlock();
			}
		});
		Thread t2 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.writeLock().lock();
				lock.writeLock().unlock();
			}
		});

		waitForQueuedThread(lock, t1);
		waitForQueuedThread(lock, t2);
		assertWriteLockedByMe(lock);
		lock.readLock().lock();
		lock.readLock().unlock();
		assertWriteLockedByMe(lock);
		lock.writeLock().unlock();
		awaitTermination(t1);
		awaitTermination(t2);
	}

	/**
	 * Write lock succeeds if write locked by current thread even if other
	 * threads are waiting for writelock
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testWriteHoldingWriteLock4() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.writeLock().lock();
		lock.writeLock().lock();
		lock.writeLock().unlock();

		Thread t1 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.writeLock().lock();
				lock.writeLock().unlock();
			}
		});
		Thread t2 = newStartedThread(new CheckedRunnable() {

			public void realRun() {
				lock.writeLock().lock();
				lock.writeLock().unlock();
			}
		});

		waitForQueuedThread(lock, t1);
		waitForQueuedThread(lock, t2);
		assertWriteLockedByMe(lock);
		assertEquals(1, lock.getWriteHoldCount());
		lock.writeLock().lock();
		assertWriteLockedByMe(lock);
		assertEquals(2, lock.getWriteHoldCount());
		lock.writeLock().unlock();
		assertWriteLockedByMe(lock);
		assertEquals(1, lock.getWriteHoldCount());
		lock.writeLock().unlock();
		awaitTermination(t1);
		awaitTermination(t2);
	}

	/**
	 * Read tryLock succeeds if readlocked but not writelocked
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testTryLockWhenReadLocked() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.readLock().lock();
		Thread t = newStartedThread(new CheckedRunnable() {

			public void realRun() throws InterruptedException {
				assertTrue(lock.readLock().tryLock(LONG_DELAY_MS, TimeUnit.MILLISECONDS));
				lock.readLock().unlock();
			}
		});

		awaitTermination(t);
		lock.readLock().unlock();
	}

	/**
	 * write tryLock fails when readlocked
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testWriteTryLockWhenReadLocked() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.readLock().lock();
		Thread t = newStartedThread(new CheckedRunnable() {

			public void realRun() throws InterruptedException {
				assertFalse(lock.writeLock().tryLock(LONG_DELAY_MS, TimeUnit.MILLISECONDS));
			}
		});

		awaitTermination(t, 2 * LONG_DELAY_MS);
		lock.readLock().unlock();
	}

	/**
	 * write timed tryLock times out if locked
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testWriteTryLock_Timeout() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.writeLock().lock();
		Thread t = newStartedThread(new CheckedRunnable() {

			public void realRun() throws InterruptedException {
				long startTime = System.nanoTime();
				long timeoutMillis = 10;
				assertFalse(lock.writeLock().tryLock(timeoutMillis, TimeUnit.MILLISECONDS));
				assertTrue(millisElapsedSince(startTime) >= timeoutMillis);
			}
		});

		awaitTermination(t);
		lock.writeLock().unlock();
	}

	/**
	 * read timed tryLock times out if write-locked
	 * 
	 * @throws TimeoutException
	 */
	@Test
	public void testReadTryLock_Timeout() throws TimeoutException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		lock.writeLock().lock();
		Thread t = newStartedThread(new CheckedRunnable() {

			public void realRun() throws InterruptedException {
				long startTime = System.nanoTime();
				long timeoutMillis = 10;
				assertFalse(lock.readLock().tryLock(timeoutMillis, TimeUnit.MILLISECONDS));
				assertTrue(millisElapsedSince(startTime) >= timeoutMillis);
			}
		});

		awaitTermination(t);
		assertTrue(((PublicDistributedReentrantReadWriteLock.WriteLock) lock.writeLock()).isHeldByCurrentThread());
		lock.writeLock().unlock();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUntimedTryReadLockNotSupported() throws InterruptedException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		assertTrue(lock.readLock().tryLock());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUntimedTryWriteLockNotSupported() throws InterruptedException {
		final PublicDistributedReentrantReadWriteLock lock = new PublicDistributedReentrantReadWriteLock(grid, "testLock");
		assertTrue(lock.writeLock().tryLock());
	}

	private void assertNotWriteLocked(PublicDistributedReentrantReadWriteLock lock) {
		assertFalse(lock.isWriteLocked());
	}

	// private void assertWriteLocked(PublicDistributedReentrantReadWriteLock
	// lock)
	// {
	// assertTrue(lock.isWriteLocked());
	// }

	private void assertWriteLockedByMe(PublicDistributedReentrantReadWriteLock lock) {
		assertTrue(lock.isWriteLocked());
		assertTrue(lock.isHeldByCurrentThread());
	}

	// private void
	// assertWriteLockedByOther(PublicDistributedReentrantReadWriteLock lock)
	// {
	// assertTrue(lock.isWriteLocked());
	// assertFalse(lock.isHeldByCurrentThread());
	// }

	private void assertHoldCount(PublicDistributedReentrantReadWriteLock lock, int count) {
		assertEquals(count, lock.getHoldCount());
	}


	DistributedDataStructureFactory grid;
	DistributedLockFactory lockFactory;

}
