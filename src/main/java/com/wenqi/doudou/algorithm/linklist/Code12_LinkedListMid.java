package com.wenqi.doudou.algorithm.linklist;

public class Code12_LinkedListMid {

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 1 2 3 4 return 2
    // 1 2 3 4 5  return 3
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 1 2 3 4 return 3
    // 1 2 3 4 5  return 3
    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }

    // 1 2 3 4 return 1
    // 1 2 3 4 5  return 2
    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        Node res = slow;
        while (fast.next != null && fast.next.next != null) {
            res = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return res;
    }

    // 1 2 3 return 1
    // 1 2 3 4 return 2
    // 1 2 3 4 5  return 2
    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        Node res = slow;
        while (fast.next != null && fast.next.next != null) {
            res = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            return res;
        } else {
            return slow;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node upMid = midOrUpMidNode(node1);
        Node downMid = midOrDownMidNode(node1);
        Node preUpMid = midOrUpMidPreNode(node1);
        Node preDownMid = midOrDownMidPreNode(node1);
        System.out.println(upMid.value);
        System.out.println(downMid.value);
        System.out.println(preUpMid.value);
        System.out.println(preDownMid.value);

    }

}
