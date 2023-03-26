package com.wenqi.doudou.algorithm.btree;

/**
 * 给定一颗二叉树头结点head，和另外两个节点a和b， 返回a和b的最低公共祖先
 */
public class LowestAncestor {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class Info {
        public boolean findA;
        public boolean findB;
        public Node ans;

        public Info(boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    public static Info process(Node node, Node A, Node B) {
        if (node == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(node.left, A, B);
        Info rightInfo = process(node.right, A, B);


        boolean findA = leftInfo.findA || rightInfo.findA || node == A;
        boolean findB = leftInfo.findB || rightInfo.findB || node == B;

        Node ans = null;
        if (leftInfo.ans!=null) {
            ans = leftInfo.ans;
        }
        if (rightInfo.ans!=null) {
            ans = rightInfo.ans;
        }
        if (ans == null && findA && findB) {
            ans = node;
        }
        return new Info(findA, findB, ans);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(0);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
////
        node2.left = node4;
        node2.right = node5;
//
        node3.left = node6;
        node3.right = node7;

        Info info = process(node1, node4, node2);
        System.out.println(info.ans.value);

    }
}
