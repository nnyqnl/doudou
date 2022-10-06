package com.wenqi.doudou.algorithm.sort;

public class SelectSort {

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 - n-1
        // 1 - n-1
        // 2 - n-1
        // i - n-1 select min value, put to i
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < n - 1; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 6, 1, 2, 3, 7, 9};
        selectSort(arr);

        printArr(arr);
    }
}
