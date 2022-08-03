package com.wenqi.doudou.leetcode;

public class NumToExcelcolumn {

    public static void main(String[] args) {
        String test = test(27);
        System.out.println(test);
        //A   65
        //Z 90
    }

    public static String test(int num) {
        StringBuilder builder = new StringBuilder();
        //
        while (num > 0) {
            int i = num % 26;
            if (i == 0) {
                i = 26;
            }
            char c = (char) (i + 64);
            builder.append(c);
            num = (num - i) / 26;
        }

        return builder.reverse().toString();
    }
}
