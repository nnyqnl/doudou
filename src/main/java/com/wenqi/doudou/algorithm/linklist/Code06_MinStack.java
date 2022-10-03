package com.wenqi.doudou.algorithm.linklist;

import java.util.*;

public class Code06_MinStack {
    public static class MinStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MinStack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }


        public void push(Integer value) {
            stackData.push(value);
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else {
                Integer peek = stackMin.peek();
                Integer i = value < peek ? value : peek;
                stackMin.push(i);
            }
        }

        public Integer pop() {
            stackMin.pop();
            return stackData.pop();
        }

        public Integer getMin() {
            return stackMin.peek();
        }
    }


    public static void main(String[] args) {
        int value = 1000;
        int times = 100000;
        int oneTestTimes = 100;

        for (int j = 0; j < times; j++) {
            int[] arr = new int[100];
            MinStack minStack = new MinStack();

            for (int i = 0; i < oneTestTimes; i++) {
                int nums = (int) (Math.random() * value);
                arr[i] = nums;
                minStack.push(nums);
            }
            Arrays.sort(arr);

            if (arr[0] != minStack.getMin()) {
                System.out.println("fuck.....");
            }
        }

        System.out.println("success!!!!");
    }
}
