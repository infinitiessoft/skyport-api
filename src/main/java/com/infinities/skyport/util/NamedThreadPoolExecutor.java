package com.infinities.skyport.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NamedThreadPoolExecutor extends ThreadPoolExecutor {

	public NamedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, String groupName, String threadNamePrefix) {
		this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new NamedThreadFactory(groupName,
				threadNamePrefix));
	}

	public NamedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
		this.allowCoreThreadTimeOut(true);
	}

}
