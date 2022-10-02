package com.wenqi.doudou.algorithm.linklist;

public class Code01_ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseLinkList(Node head) {
        Node pre = null;
        Node temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode reverseDoubleLinkList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            head.pre = temp;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static void testReverseLinkList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node node = reverseLinkList(node1);
        System.out.println(node.value);
    }

    public static void testDoubleReverseLinkList() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node2.pre = node1;
        node3.pre = node2;
        node4.pre = node3;

        DoubleNode node = reverseDoubleLinkList(node1);
        System.out.println(node.value);
    }


    public static void main(String[] args) {
        testReverseLinkList();
        testDoubleReverseLinkList();
    }
}
