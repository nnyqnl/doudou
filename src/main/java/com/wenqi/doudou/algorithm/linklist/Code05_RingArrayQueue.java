package com.wenqi.doudou.algorithm.linklist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code05_RingArrayQueue {

    public static class MyQueue {
        private int[] arr;
        private int polli;
        private int pushi;
        private int size;
        private int length;

        public MyQueue(int length) {
            this.arr = new int[length];
            this.polli = 0;
            this.pushi = 0;
            this.size = 0;
            this.length = length;
        }

        public void push(int a) {
            if (size >= length) {
                throw new RuntimeException("Stack is full");
            }
            arr[pushi] = a;
            pushi = nexti(pushi);
            size++;
        }

        private int nexti(int i) {
            return i < length - 1 ? i + 1 : 0;
        }

        public int poll() {
            if (size < 1) {
                throw new RuntimeException("Stack is empty");
            }
            int ans = arr[polli];
            polli = nexti(polli);
            size--;
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == length;
        }
    }

    public static void main(String[] args) {
        int value = 1000;
        int times = 100000;
        int oneTestTimes = 100;

        for (int i = 0; i < times; i++) {
            MyQueue myQueue = new MyQueue(8);
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestTimes; j++) {

                int nums = (int) (Math.random() * value);

                // check myQueue
                if (queue.isEmpty()) {
                    myQueue.push(nums);
                    queue.add(nums);
                } else {
                    if (Math.random() > 0.5 && !myQueue.isFull()) {
                        myQueue.push(nums);
                        queue.add(nums);
                    } else {
                        Integer poll = myQueue.poll();
                        Integer poll1 = queue.poll();
                        if (!poll1.equals(poll)) {
                            System.out.println("oh no");
                        }
                    }
                }
            }

        }

        System.out.println("success!!!!");

    }
}
