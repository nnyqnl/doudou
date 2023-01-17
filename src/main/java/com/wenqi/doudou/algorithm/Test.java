package com.wenqi.doudou.algorithm;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static int solution(int[] a) {
        // Write your answer here
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        int length = set.size();
        if (length == a.length || length == 1 || length == 2) {
            return length;
        }
        int range = length;
        while (!aaa(range, a, set) && range < a.length) {
            range++;
        }
        return range;

    }

    private static boolean aaa(int range, int[] a, Set<Integer> set) {
        int start = 0;
        while (start + range <= a.length) {
            Set<Integer> s = new HashSet<Integer>(set);
            for (int i = start; i < start + range; i++) {
                s.remove(a[i]);
            }
            if (s.isEmpty()) {
                return true;
            }
            start++;
        }
        return false;

    }

    public static void main(String[] args) {
        int[] a = {1,2,1,2,3,7,1,5};
        int solution = solution(a);
        System.out.println(solution);

    }
// 反转字符串， 如下
// 123'abc'543  ->   123'cba'543
// 123'ab'yui'c'543 -> 123'c'yui'ba'543



    //给定一个数组，找出一个最大子数组，要求子数组是数组连续的一部分，且拥有给定数组所有的值，返回最大子数组的长度

    //{1,2,3,1} -> 3
    //{1,2,1,2,1} -> 2
    //{1,2,1,2,3,7,1,5};   ->  5

}
