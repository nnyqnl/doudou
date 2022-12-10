package com.wenqi.doudou.algorithm.nocompare;

import com.wenqi.doudou.algorithm.utils.Util;

import java.util.Arrays;

//
public class Code01_CountSort {
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            int count = bucket[i];
            if (count != 0) {
                for (int k = 0; k < count; k++) {
                    arr[j++] = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int[] ints = Util.generatePositiveRandomArray(20, 200);
            int[] copyArray = Util.copyArray(ints);

            countSort(ints);
            Arrays.sort(copyArray);

            boolean equal = Util.isEqual(ints, copyArray);
            if (!equal) {
                System.out.println("fuck....");
                Util.printArray(ints);
            }
        }

        System.out.println("luck....");
    }
}
