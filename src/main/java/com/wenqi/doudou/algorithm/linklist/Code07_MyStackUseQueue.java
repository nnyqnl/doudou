package com.wenqi.doudou.algorithm.linklist;

import java.util.LinkedList;
import java.util.Stack;

public class Code07_MyStackUseQueue {
    public static class MyStack {
        private LinkedList<Integer> dataQueue;//只用单向链表的性质
        private LinkedList<Integer> helpQueue;

        public MyStack() {
            dataQueue = new LinkedList<>();
            helpQueue = new LinkedList<>();
        }


        public void push(Integer value) {
            dataQueue.push(value);
        }

        public Integer pop() {
            while (dataQueue.size() > 1) {
                Integer value = dataQueue.pollLast();
                helpQueue.push(value);
            }
            Integer poll = dataQueue.poll();
            LinkedList<Integer> temp = helpQueue;
            helpQueue = dataQueue;
            dataQueue = temp;
            return poll;
        }

    }


    public static void main(String[] args) {

        int value = 1000;


        for (int j = 0; j < 10000; j++) {

            MyStack myStack = new MyStack();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < 100; i++) {
                int nums = (int) (Math.random() * value);

                if (stack.isEmpty()) {
                    stack.push(nums);
                    myStack.push(nums);
                } else {
                    if (Math.random() > 0.5) {
                        stack.push(nums);
                        myStack.push(nums);
                    } else {
                        Integer pop = stack.pop();
                        int myPop = myStack.pop();
                        if (!pop.equals(myPop)) {
                            System.out.println("fuc....k");
                        }
                    }
                }
            }
        }
        System.out.println("success......");


    }
}
