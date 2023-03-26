package com.wenqi.doudou.algorithm.btree;

/**
 * 判断二叉树是不是完全二叉树
 * 完全二叉树：满的，或者依次变满
 * <p>
 * <p>
 * 左树右树都是满二叉树，并高度相同
 * 左树是完全二叉树，右树是满二叉树， 左树高度=右树高度+1
 * 左树是满二叉树，右树是满二叉树， 左树高度=右树高度+1
 * 左树是满二叉树，右树是完全二叉树， 左树高度=右树高度
 */
public class IsCBT {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class Info {
        public boolean isFull;//是否是满二叉树
        public boolean isC;//是否是完全二叉树
        public int high;

        public Info(boolean isFull, boolean isC, Integer high) {
            this.isFull = isFull;
            this.isC = isC;
            this.high = high;
        }
    }

    public static Info process(Node node) {
        if (node == null) {
            return new Info(true, true, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);


        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.high == rightInfo.high;
        int high = Math.max(leftInfo.high, rightInfo.high) + 1;
        boolean isC = isFull;

        if (leftInfo.isC && rightInfo.isFull && leftInfo.high == rightInfo.high + 1) {
            isC = true;
        }

        if (leftInfo.isFull && rightInfo.isFull && leftInfo.high == rightInfo.high + 1) {
            isC = true;
        }
        if (leftInfo.isFull && rightInfo.isC && leftInfo.high == rightInfo.high) {
            isC = true;
        }

        return new Info(isFull, isC, high);
    }

    public static void main(String[] args) {


    }
}
