package com.wenqi.doudou.sort;

public class BubblingSort {
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void bubblingSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 ~ n-1
        // 0 ~ n-2
        // 0 ~ n-3

        int n = arr.length;
        for (int end = n - 1; end >= 0; end--) {
            // 0 ~ end, do something
            for (int second = 1; second <= end; second++) {
                if (arr[second] < arr[second - 1]) {
                    swap(arr, second - 1, second);
                }

            }


        }

    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 6, 1, 2, 3, 7, 9};
        bubblingSort(arr);

        printArr(arr);
    }
}
