package com.wenqi.doudou.algorithm.btree;

/**
 * 判断二叉树是不是满二叉树
 * 满二叉树满足： 节点数 = 2的n方 - 1， 其中n层数
 */
public class IsFull {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class Info {
        public Integer level;
        public Integer num;

        public Info(int level, Integer num) {
            this.level = level;
            this.num = num;
        }
    }

    public static Info process(Node node) {
        if (node == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);


        int level = Math.max(leftInfo.level, rightInfo.level) + 1;
        int num = leftInfo.num + rightInfo.num + 1;

        return new Info(level, num);
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
//        node3.right = node7;

        Info info = process(node1);
        if (info.num == (1 << info.level) - 1) {
            System.out.println("是满二叉树");
        } else {
            System.out.println("不是满二叉树");
        }

    }
}
