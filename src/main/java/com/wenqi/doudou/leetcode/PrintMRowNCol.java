package com.wenqi.doudou.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * m = 5, n = 4
 * <p>
 * 6    5   1   0
 * 13   7   4   2
 * 14   12  8   3
 * 18   15  11  9
 * 19   17  16  10
 */
public class PrintMRowNCol {

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        Map<String, Integer> map = new HashMap<>();

        int x = n - 1;
        int y = 0;
        map.put(x + "_" + y, 0);
        map.put(--x + "_" + "0", 1);


        boolean flag = true;
        for (int i = 2; i < m * n; i++) {
            if (x == n - 1 && flag && y < m - 1) {
                flag = false;
                map.put(x + "_" + ++y, i);
                continue;
            }
            if (x == 0 && !flag) {
                flag = true;
                map.put(x + "_" + ++y, i);
                continue;
            }
            if (y == 0 && !flag) {
                flag = true;
                map.put(--x + "_" + y, i);
                continue;
            }
            if (y == m - 1 && flag) {
                flag = false;
                map.put(--x + "_" + y, i);
                continue;
            }
            if (flag) {
                map.put(++x + "_" + ++y, i);
            } else {
                map.put(--x + "_" + --y, i);
            }

        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(map.get(j + "_" + i) == null ? "xx" : map.get(j + "_" + i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
