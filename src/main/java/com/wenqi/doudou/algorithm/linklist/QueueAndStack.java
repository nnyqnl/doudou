package com.wenqi.doudou.algorithm.linklist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueAndStack {

    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }


    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value) {
            Node<T> node = new Node<>(value);
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            head.last = node;
            node.next = head;
            head = node;

        }

        public void addFromTail(T value) {
            Node<T> node = new Node<>(value);
            if (tail == null) {
                tail = node;
                head = node;
                return;
            }
            tail.next = node;
            node.last = tail;
            tail = node;

        }

        public T popFromHead() {
            if (head == null) {
                return null;
            }
            if (head == tail) {
                Node<T> temp = head;
                head = null;
                tail = null;
                return temp.value;
            }
            Node<T> temp = head;
            head = head.next;
            head.last = null;
            temp.next = null;
            return temp.value;
        }

        public T popFromTail() {
            if (tail == null) {
                return null;
            }
            if (head == tail) {
                Node<T> temp = tail;
                head = null;
                tail = null;
                return temp.value;
            }

            Node<T> temp = tail;
            tail = tail.last;
            tail.next = null;
            temp.last = null;
            return temp.value;

        }

        public boolean isEmpty() {
            return head == null;
        }

    }

    public static class MyStack<T> {

        private DoubleEndsQueue<T> queue;

        public MyStack() {
            this.queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromHead();
        }

    }

    public static class MyQueue<T> {

        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            this.queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.popFromTail();

        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        int value = 1000;
        int times = 100000;
        int oneTestTimes = 100;

        for (int i = 0; i < times; i++) {
            MyQueue<Integer> myQueue = new MyQueue<>();
            Queue<Integer> queue = new LinkedList<>();
            MyStack<Integer> myStack = new MyStack<>();
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < oneTestTimes; j++) {

                int nums = (int) (Math.random() * value);

                // check myQueue
                if (queue.isEmpty()) {
                    myQueue.push(nums);
                    queue.add(nums);
                } else {
                    if (Math.random() > 0.5) {
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

                // check myStack
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() > 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        Integer pop = myStack.pop();
                        Integer pop1 = stack.pop();
                        if (!pop.equals(pop1)) {
                            System.out.println("oh no");
                        }
                    }
                }

            }

        }

        System.out.println("success!!!!");

    }
}
