package com.wenqi.doudou.threadDemo;

/**
 * New
 * <p>
 * Runnable: A runnable thread may or may not actually be running.
 * <p>
 * Blocked: When the thread try to acquire an intrinsic lock(but not in java.util.concurrent library) that held by another thread, it becomes blocked.
 * <p>
 * Waiting: When the thread waits for another thread to notify the scheduler of a condition, it enters the waiting stats.(o.wait(), t.join())
 * <p>
 * TimeWaiting: Several methods hava a timeout parameter, like Thread.sleep(time), o.wait(time), t.join(time). Calling them causes the thread to enter timeWaiting state.
 * <p>
 * Terminated
 */
public class ThreadState {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("t1 run() state: " + this.getState());

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }


    public static void main(String[] args) {

        MyThread t1 = new MyThread();


        Thread t2 = new Thread(() -> {
            try {
                t1.join(); //
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        System.out.println("t1 before start state: " + t1.getState());  // new

        System.out.println("t2 before start state: " + t2.getState());  //new

        t1.start();
        t2.start();

//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("t2 after start state: " + t2.getState());


        System.out.println("t1 after start state: " + t1.getState());

    }
}
