package com.wenqi.doudou.threadPoolDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestNewCachedThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(1000);
//
//            executor.execute(() -> {
//                String name = Thread.currentThread().getName();
//                System.out.println(name);
//            });
//
//
//        }
        Future<String> future = executor.submit(() -> {
            System.out.println("submit" + Thread.currentThread().getName());
            Thread.sleep(5000);
            return "success";
        });

        String s = future.get();
        System.out.println(s);
        executor.shutdown();

    }
}
