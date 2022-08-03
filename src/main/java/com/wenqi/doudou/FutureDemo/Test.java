package com.wenqi.doudou.FutureDemo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Deque<Character> deque = new LinkedList<Character>();
        Future<Integer> future = new SquareCalculator().calculate(10);

//        while(!future.isDone()) {
//            System.out.println("Calculating...");
//            Thread.sleep(300);
////        }
//
//        System.out.println("before get");
//        Integer result = future.get();
//        System.out.println(result);


        boolean canceled = future.cancel(false);
        System.out.println(canceled);
    }
}
