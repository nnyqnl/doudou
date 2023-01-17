package com.wenqi.doudou.threadPoolDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFutureDemo {
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            9,
            20,
            60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100));

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Void>> list = new ArrayList<>();
        Map<Integer, String> map = new ConcurrentHashMap<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            AtomicInteger integer = new AtomicInteger(i);
            int finalI = i;
            CompletableFuture<Void> f = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + "===" + finalI);
            }, threadPoolExecutor);

            list.add(f);


        }

        CompletableFuture[] completableFutures = list.toArray(new CompletableFuture[0]);
        CompletableFuture.allOf(completableFutures).get();

        System.out.println(System.currentTimeMillis() - start);
        threadPoolExecutor.shutdown();
    }

}
