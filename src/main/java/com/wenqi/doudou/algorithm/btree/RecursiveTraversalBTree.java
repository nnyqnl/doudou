package com.wenqi.doudou.algorithm.btree;

public class RecursiveTraversalBTree {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre((head.left));
        pre((head.right));
    }

    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos((head.left));
        pos((head.right));
        System.out.println(head.value);
    }

    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in((head.left));
        System.out.println(head.value);
        in((head.right));
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
