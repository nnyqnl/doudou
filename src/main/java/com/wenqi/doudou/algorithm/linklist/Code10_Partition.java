package com.wenqi.doudou.algorithm.linklist;

public class Code10_Partition {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }

        int less = L - 1;
        int i = L;
        int num = arr[R];
        while (i < R) {
            if (arr[i] < num) {
                swap(arr, i, ++less);
            }
            i++;
        }
        return less + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 3, 6, 6, 6, 6, 1, 1, 1, 1, 9, 9, 9, 2, 8, 6};
        partition(arr, 0, arr.length - 1);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
