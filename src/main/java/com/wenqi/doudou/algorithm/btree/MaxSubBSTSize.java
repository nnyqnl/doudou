package com.wenqi.doudou.algorithm.btree;

/**
 * 给定一个二叉树，返回最大二叉搜索子树的节点数
 * 搜索二叉树，每个节点的值都不一样，左树的值都比我小，右树的值都比我大，每个子树都如此
 * <p>
 * 二叉树的递归套路
 * 1 假设以X节点为头，假设可以像X左树和X右树要任何信息
 * 2 在上一步的假设下，讨论以X为头节点的树，得到答案的可能性（最重要）
 * 3列出所有可能性后，确定到底需要向左树和右树要什么样的信息
 * 4 把左树信息和右树信息求全集，就是任何一颗子树都需要返回的信息S
 * 递归函数都返回S， 每一课子树都这么要求
 * 写代码，在代码中考虑如何把左树和右树整合出整颗树的信息
 */
public class MaxSubBSTSize {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class Info {
        public boolean isBST;
        public int maxSubBSTSize;

        public Integer max;

        public Integer min;

        public Info(boolean isBST, int maxSearchNum, Integer max, Integer min) {
            this.isBST = isBST;
            this.maxSubBSTSize = maxSearchNum;
            this.max = max;
            this.min = min;
        }
    }

    public static Info process(Node node) {
        if (node == null) {
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);


        int max = node.value;
        int min = node.value;

        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }
        boolean isBST = false;
        int maxSubBSTSize = 0;

        if (leftInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, leftInfo.maxSubBSTSize);
        }
        if (rightInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }

        if ((leftInfo == null || leftInfo.isBST)
            && (rightInfo == null || rightInfo.isBST)
            && (leftInfo == null || leftInfo.max < node.value)
            && (rightInfo == null || rightInfo.min > node.value)
        ) {
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize)
                + 1;
            isBST = true;
        }
        return new Info(isBST, maxSubBSTSize, max, min);
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
//        node2.right = node5;
//
//        node3.left = node6;
        node3.right = node7;

        Info info = process(node1);
        System.out.println(info.maxSubBSTSize);

    }
}
