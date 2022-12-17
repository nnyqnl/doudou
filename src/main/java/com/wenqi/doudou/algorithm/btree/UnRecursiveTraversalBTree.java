package com.wenqi.doudou.algorithm.btree;

import java.util.Stack;

public class UnRecursiveTraversalBTree {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // head left right
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.value);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

    }

    // left right head

    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            stack2.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value);
        }
    }

    // left head right
    public static void in(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    Node pop = stack.pop();
                    System.out.println(pop.value);
                    head = pop.right;
                }

            }
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.left = node2;
        node.right = node3;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.left = node4;
        node2.right = node5;
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node3.left = node6;
        node3.right = node7;

        System.out.println("pre==========");
        pre(node);
        System.out.println("pos==========");
        pos(node);
        System.out.println("in==========");
        in(node);
    }
}
