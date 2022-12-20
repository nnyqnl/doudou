package com.wenqi.doudou.algorithm.linklist;

import java.util.HashSet;

public class Code05_FindFirstIntersectNode {

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        Node loopNode = getLoopNode(head1);
        Node loopNode2 = getLoopNode(head2);

        if (loopNode == null && loopNode2 == null) {
            return noLoop(head1, head2);
        }
        if (loopNode != null && loopNode2 != null) {
            return bothLoop(head1, loopNode, head2, loopNode2);
        }

        // 不可能存在一个有环的单向连表一个无环相交
        return null;

    }

    private static Node bothLoop(Node head1, Node loopNode, Node head2, Node loopNode2) {
        if (loopNode == loopNode2) {

            Node cur1 = head1;
            Node cur2 = head2;

            int length1 = 0;
            while (cur1 != loopNode) {
                length1++;
                cur1 = cur1.next;
            }
            length1++;
            int length2 = 0;
            while (cur2 != loopNode2) {
                length2++;
                cur2 = cur2.next;
            }
            length2++;

            cur1 = head1;
            cur2 = head2;

            int n = length1 - length2;
            for (int i = 0; i < Math.abs(n); i++) {
                if (n > 0) {
                    cur1 = cur1.next;
                } else {
                    cur2 = cur2.next;
                }
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return cur1;
        } else {
            Node cur = loopNode.next;
            while (cur != loopNode) {
                if (cur == loopNode2) {
                    return loopNode;
                }
                cur = cur.next;
            }
            return null;
        }

    }

    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;

        int length1 = 1;
        while (cur1.next != null) {
            length1++;
            cur1 = cur1.next;
        }
        int length2 = 1;
        while (cur2.next != null) {
            length2++;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        cur1 = head1;
        cur2 = head2;

        int n = length1 - length2;
        for (int i = 0; i < Math.abs(n); i++) {
            if (n > 0) {
                cur1 = cur1.next;
            } else {
                cur2 = cur2.next;
            }
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node cur = head;
        HashSet<Node> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    public static Node getLoopNode2(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2 == null || n2.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n1 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    public static void main(String[] args) {

        Node commonNode = new Node(6);
        Node test;
        test = new Node(3);
        test.next = new Node(5);
        test.next.next = commonNode;
        test.next.next.next = new Node(2);
        test.next.next.next.next = new Node(10);
        test.next.next.next.next.next = test.next;

        Node test2;
        test2 = new Node(3);
        test2.next = new Node(5);
        test2.next.next = new Node(6);
        test2.next.next.next = new Node(2);
        test2.next.next.next.next = new Node(10);
        test2.next.next.next.next.next = commonNode;

        Node loopNode = getLoopNode(test);
        Node loopNode2 = getLoopNode2(test2);

        System.out.println(loopNode == null ? "null" : loopNode.value);
        System.out.println(loopNode2 == null ? "null" : loopNode2.value);


        Node intersectNode = getIntersectNode(test, test2);
        System.out.println(intersectNode == null ? "null" : intersectNode.value);


    }
}
