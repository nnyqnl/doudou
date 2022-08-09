package com.wenqi.doudou.sort;

public class InsertSort {
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 ~ 0 done
        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ n-1
        int n = arr.length;

        for (int i = 1; i < n - 1; i++) {
            int newNumIndex = i;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex, newNumIndex - 1);
                newNumIndex--;
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 6, 1, 2, 3, 7, 9};
        insertSort(arr);
        printArr(arr);
    }
}
