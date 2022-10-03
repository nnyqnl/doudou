package com.wenqi.doudou.algorithm.linklist;

import java.util.Stack;

public class Code08_MyQueueUseTwoStack {
    public static class MyQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void pushToPop() {
            // popStack为空时，才能倒；并且必须一次性倒完
            if (!popStack.isEmpty()) {
                return;
            }

            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        public void add(Integer value) {
            pushStack.push(value);
            pushToPop();
        }

        public Integer poll() {
            pushToPop();
            return popStack.pop();
        }

        public Integer peek() {
            pushToPop();
            return popStack.peek();
        }
    }


    public static void main(String[] args) {
        MyQueue test = new MyQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
