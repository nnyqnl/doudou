package com.wenqi.doudou.algorithm.linklist;

import java.util.Stack;

public class Code13_LinkedListHuiWen {

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //给定一个单链表的头节点head，请判断该链表是否为回文结构。

    // 1 2 3 4 3 2 1
    // extra space O(n)
    public static boolean isHuiWen(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;

    }


    // extra space O(n/2)
    public static boolean isHuiWen2(Node head) {
        Node mid = midOrDownMidNode(head);

        Stack<Node> stack = new Stack<>();
        while (mid != null) {
            stack.push(mid);
            mid = mid.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;

    }

    // extra space O(0)
    public static boolean isHuiWen3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = midOrUpMidNode(head); // n1 is mid or upMid
        // 1 2 3 4 5
        Node n2 = n1.next;
        n1.next = null;
        while (n2 != null) {
            Node n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        Node nx = n2;

        while (head != null && n1 != null) {
            if (head.value != n1.value) {
                return false;
            }
            head = head.next;
            n1 = n1.next;
        }
        return true;

    }

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

    public static void main(String[] args) {
        Node test;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(40);
        test.next.next.next.next.next = new Node(3);
        test.next.next.next.next.next.next = new Node(2);
        test.next.next.next.next.next.next.next = new Node(1);
        test.next.next.next.next.next.next.next.next = new Node(10);

        System.out.println(isHuiWen(test));
        System.out.println(isHuiWen2(test));
        System.out.println(isHuiWen3(test));

    }
}
