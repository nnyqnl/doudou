package com.wenqi.doudou.pDemo;

public class Test {
    public static void main(String[] args) {
        int times = 1000000;
        int count = 0;

        for (int i = 0; i < times; i++) {
            if (Math.random()< 0.59) {
                count++;
            }
        }

        System.out.println((double) count / (double) times);

        count = 0;
        for (int i = 0; i < times; i++) {
            if (xToXPower2() < 0.7) {
                count++;
            }
        }
        System.out.println((double) count / (double) times);

    }

    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }
}
