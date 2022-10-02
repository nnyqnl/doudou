package com.wenqi.doudou.algorithm.linklist;

import java.util.Stack;

public class Code04_ArrayStack {


    public static class ArrayStack {
        private int[] arr;
        private int index;
        private int length;

        public ArrayStack(int length) {
            this.arr = new int[length];
            this.index = 0;
            this.length = length;
        }

        public void push(int a) {
            if (index >= length) {
                throw new RuntimeException("Stack is full");
            }
            arr[index] = a;
            index++;
        }

        public int pop() {
            if (index < 0) {
                throw new RuntimeException("Stack is empty");
            }
            index--;
            return arr[index];
        }

        public boolean isEmpty() {
            return index == 0;
        }

        public boolean isFull() {
            return index == length;
        }
    }


    public static void main(String[] args) {

        int value = 1000;
        ArrayStack myStack = new ArrayStack(5);
        Stack<Integer> stack = new Stack<>();

        for (int j = 0; j < 10000; j++) {
            for (int i = 0; i < 100; i++) {
                int nums = (int) (Math.random() * value);

                if (stack.isEmpty()) {
                    stack.push(nums);
                    myStack.push(nums);
                } else {
                    if (Math.random() > 0.5 && !myStack.isFull()) {
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
