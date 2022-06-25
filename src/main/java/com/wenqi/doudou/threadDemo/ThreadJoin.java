package com.wenqi.doudou.threadDemo;

/**
 * join()方法就是当前的线程等待join的线程，等执行结束，在执行当前线程。
 */
public class ThreadJoin {
    static void joinTest() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join(); // t2 hold, t1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

    }

    public static void main(String[] args) {
        joinTest();
    }
}
