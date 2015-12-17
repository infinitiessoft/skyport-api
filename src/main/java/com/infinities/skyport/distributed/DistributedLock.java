package com.infinities.skyport.distributed;

import java.util.concurrent.TimeUnit;

public interface DistributedLock extends DistributedObject {

    /**
     * {@inheritDoc}
     */
    void lock();

    /**
     * {@inheritDoc}
     */
    boolean tryLock();

    /**
     * {@inheritDoc}
     */
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    /**
     * Releases the lock.
     */
    void unlock();

    /**
     * Acquires the lock for the specified lease time.
     * <p>After lease time, lock will be released..
     * <p/>
     * <p>If the lock is not available then
     * the current thread becomes disabled for thread scheduling
     * purposes and lies dormant until the lock has been acquired.
     * <p/>
     *
     * @param leaseTime time to wait before releasing the lock.
     * @param timeUnit unit of time to specify lease time.
     *
     * @throws IllegalMonitorStateException if the current thread does not
     * hold this lock
     */
    void lock(long leaseTime, TimeUnit timeUnit);

    /**
     * Releases the lock regardless of the lock owner.
     * It always successfully unlocks, never blocks  and returns immediately.
     */
    void forceUnlock();


    /**
     * Returns a new {@link ICondition} instance that is bound to this
     * {@code ILock} instance with given name.
     *
     * <p>Before waiting on the condition the lock must be held by the
     * current thread.
     * A call to {@link ICondition#await()} will atomically release the lock
     * before waiting and re-acquire the lock before the wait returns.
     *
     * @param name identifier of the new condition instance
     * @return A new {@link ICondition} instance for this {@code ILock} instance
     * @throws java.lang.NullPointerException if name is null.
     */
    DistributedCondition newCondition(String name);

    /**
     * Returns whether this lock is locked or not.
     *
     * @return {@code true} if this lock is locked, {@code false} otherwise.
     */
    boolean isLocked();

    /**
     * Returns whether this lock is locked by current thread or not.
     *
     * @return {@code true} if this lock is locked by current thread, {@code false} otherwise.
     */
    boolean isLockedByCurrentThread();

    /**
     * Returns re-entrant lock hold count, regardless of lock ownership.
     *
     * @return lock hold count.
     */
    int getLockCount();

    /**
     * Returns remaining lease time in milliseconds.
     * If the lock is not locked then -1 will be returned.
     *
     * @return remaining lease time in milliseconds.
     */
    long getRemainingLeaseTime();


}
