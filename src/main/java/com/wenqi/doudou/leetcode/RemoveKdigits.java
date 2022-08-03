package com.wenqi.doudou.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits {
    public static void main(String[] args) {
        String s = removeKdigits("10", 1);
        System.out.println(s);
    }

    /**
     * 1 4 3 2 2 1 9
     * 1 4 3 2 6 7 9
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {

        Deque<Character> queue = new LinkedList<>();
        queue.add('0');
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && num.charAt(i) < queue.peekLast()) {
                queue.pollLast();
                k--;
            }
            queue.add(num.charAt(i));
        }

        for (int i = 0; i < k; i++) {
            queue.pollLast();
        }

        queue.pollFirst();

        if (queue.isEmpty()) {
            return "0";
        }

        while (queue.peekLast() != null && '0' == queue.peekFirst()) {
            queue.pollFirst();
        }

        StringBuilder builder = new StringBuilder();
        if (queue.isEmpty()) {
            return "0";
        }
        while (!queue.isEmpty()) {
            builder.append(queue.pollFirst());
        }
        return builder.toString();


    }
}
