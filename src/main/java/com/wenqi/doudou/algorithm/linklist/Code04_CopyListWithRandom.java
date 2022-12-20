package com.wenqi.doudou.algorithm.linklist;

import java.util.HashMap;
import java.util.Map;

public class Code04_CopyListWithRandom {
    static class Node {
        public int value;
        public Node next;
        public Node random;

        public Node(int value) {
            this.value = value;
        }
    }

    // extra space O(n)
    public static Node copyListWithRand1(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.value);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next;
        while (cur != null) {
            Node node = new Node(cur.value);
            next = cur.next;
            cur.next = node;
            node.next = next;

            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            Node n = cur.next;
            n.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        // split
        cur = head;
        Node res = cur.next;
        while (cur != null) {
            Node n = cur.next;
            cur.next = n.next;
            n.next = cur.next == null ? null : cur.next.next;
            cur = cur.next;
        }
        return res;
    }


    public static void printRandLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value);
            System.out.print("  ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        while (cur != null) {
            System.out.print(cur.random == null ? null : cur.random.value);
            System.out.print("  ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node test = new Node(1);
        test.next = new Node(2);
        test.next.next = new Node(3);
        test.next.next.next = new Node(4);

        test.random = test.next.next;
        test.next.random = test;

        printRandLinkedList(test);
        Node node = copyListWithRand1(test);
        printRandLinkedList(node);
        Node node2 = copyListWithRand2(test);
        printRandLinkedList(node2);


    }
}
