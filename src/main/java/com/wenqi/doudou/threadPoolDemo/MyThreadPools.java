package com.wenqi.doudou.threadPoolDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPools {
    private volatile static MyThreadPools threadPools = null;
    private static final int corePoolSize = 1;
    private static final int maxPoolSize = 2;
    private static final long keepAliveTime = 60;
    private static final TimeUnit unit = TimeUnit.SECONDS;
    private static final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

    public static ThreadPoolExecutor threadPoolExecutor = null;

    private MyThreadPools() {
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, unit, arrayBlockingQueue,
                (Runnable r, ThreadPoolExecutor executor) -> {
                    throw new RuntimeException("reject");
                });
    }

    public static void executor(Runnable runnable) {
        if (threadPools == null) {
            synchronized (MyThreadPools.class) {
                if (threadPools == null) {
                    threadPools = new MyThreadPools();
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            threadPoolExecutor.execute(runnable);

        }
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        System.out.println(1111);
        MyThreadPools.executor(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println(222);
    }
}
