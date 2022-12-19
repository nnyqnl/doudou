package com.wenqi.doudou.algorithm.btree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LevelMaxWidth {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int levelMaxWidthWithMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> map = new HashMap<>();  // 节点和它所在的层
        int max = 0;
        int currentLevelMax = 0;
        int currentLevel = 1;
        queue.add(head);
        map.put(head, 1);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Integer currentNodeLevel = map.get(poll);
            if (poll.left != null) {
                queue.add(poll.left);
                map.put(poll.left, currentNodeLevel + 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                map.put(poll.right, currentNodeLevel + 1);
            }
            if (currentLevel == currentNodeLevel) {
                currentLevelMax++;
            } else {
                max = Math.max(max, currentLevelMax);
                currentLevelMax = 1;
                currentLevel++;
            }

        }
        max = Math.max(max, currentLevelMax);
        return max;
    }

    public static int levelMaxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int max = 0;
        int currentLevelMax = 0;
        Node currentRight;
        queue.add(head);
        currentRight = head;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
            currentLevelMax++;
            if (poll == currentRight) {
                max = Math.max(max, currentLevelMax);
                currentLevelMax = 0;
                // 这是错的，因为下一次的最右，不一定是上一层最右的子
                if (poll.left != null) {
                    currentRight = poll.left;
                }
                if (poll.right != null) {
                    currentRight = poll.right;
                }
            }

        }
        return max;
    }

    public static int levelMaxWidthNoMap2(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int max = 0;
        int currentLevelMax = 0;
        Node currentRight;
        Node nextRight = null;
        queue.add(head);
        currentRight = head;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
                nextRight = poll.left;
            }
            if (poll.right != null) {
                queue.add(poll.right);
                nextRight = poll.right;
            }
            currentLevelMax++;
            if (poll == currentRight) {
                max = Math.max(max, currentLevelMax);
                currentLevelMax = 0;
                currentRight = nextRight;
            }

        }
        return max;
    }

    /**
     * 1
     * 2 3
     * 4 5
     * 6 7 8
     *
     * @param args
     */

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.left = node2;
        node.right = node3;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.left = node4;
        node2.right = node5;
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node4.left = node6;
        node4.right = node7;
        Node node8 = new Node(8);
        node5.left = node8;

        System.out.println("level max ==========");
        int i = levelMaxWidthWithMap(node);
        int j = levelMaxWidthNoMap(node);
        int k = levelMaxWidthNoMap2(node);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

}
