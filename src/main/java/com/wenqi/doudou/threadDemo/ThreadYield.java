package com.wenqi.doudou.threadDemo;

/**
 * yield()方法只是让当前线程停一停，让其他线程有机会获得CPU执行权，当然只是让一让，后面谁能抢到CPU执行权不好说。
 */
public class ThreadYield {
    static void yieldTest() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if (i % 10 == 0) Thread.yield();
            }
        }).start();
    }

    public static void main(String[] args) {
        yieldTest();
    }
}
