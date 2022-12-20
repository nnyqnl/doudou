package com.wenqi.doudou.algorithm.linklist;

import java.util.Stack;

public class Code14_SmallerEqualBigger {

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        int i = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            i++;
        }

        cur = head;
        Node[] arr = new Node[i];
        int j = 0;
        while (cur != null) {
            arr[j] = cur;
            cur = cur.next;
            j++;
        }

        // partition
        arrPartition(arr, pivot);

        for (int k = 1; k < arr.length; k++) {
            arr[k - 1].next = arr[k];
        }
        arr[arr.length - 1].next = null;
        return arr[0];

    }

    public static Node listPartition2(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        Node sHead = null;
        Node sTail = null;
        Node eHead = null;
        Node eTail = null;
        Node bHead = null;
        Node bTail = null;
        Node temp = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sHead == null) {
                    sHead = head;
                    sTail = head;
                } else {
                    sTail.next = head;
                    sTail = head;
                }
            }
            if (head.value == pivot) {
                if (eHead == null) {
                    eHead = head;
                    eTail = head;
                } else {
                    eTail.next = head;
                    eTail = head;
                }
            }
            if (head.value > pivot) {
                if (bHead == null) {
                    bHead = head;
                    bTail = head;
                } else {
                    bTail.next = head;
                    bTail = head;
                }
            }

            head = next;
        }

//        sHead sTail
//        eHead eTail
//        bHead bTail

        Node res = sHead != null ? sHead : (eHead != null ? eHead : bHead);
        if (sHead != null) {
            if (eHead != null) {
                sTail.next = eHead;
                eTail.next = bHead;
            } else {
                sTail.next = bHead;
            }
        } else if (eHead != null) {
            eTail.next = bHead;
        }
        return res;
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node test;
        test = new Node(3);
        test.next = new Node(5);
        test.next.next = new Node(6);
        test.next.next.next = new Node(2);
        test.next.next.next.next = new Node(10);
        test.next.next.next.next.next = new Node(0);
        test.next.next.next.next.next.next = new Node(4);
        test.next.next.next.next.next.next.next = new Node(5);
        test.next.next.next.next.next.next.next.next = new Node(1);

        Node node = listPartition1(test, 5);
//        Node node2 = listPartition2(test, 4);

        printNode(node);
        System.out.println("-------------------");
//        printNode(node2);

    }
}
