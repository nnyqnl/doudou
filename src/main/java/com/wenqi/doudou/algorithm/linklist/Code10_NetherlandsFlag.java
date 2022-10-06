package com.wenqi.doudou.algorithm.linklist;

public class Code10_NetherlandsFlag {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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

    //在数组的L..R范围内，用arr[R]作为基准，小于他的放左边，等于他的在中间，大于的放右边
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }

        int i = L;
        int less = L - 1;
        int more = R + 1;
        int temp = arr[R];
        while (i < more) {
            if (arr[i] < temp) {
                swap(arr, ++less, i++);
                continue;
            }
            if (arr[i] == temp) {
                i++;
                continue;
            }
            if (arr[i] > temp) {
                swap(arr, i, --more);
            }
        }
        printArray(arr);
        return new int[]{less + 1, more - 1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 5, 4, 3, 5};
        int[] ints = netherlandsFlag(arr, 0, 6);
        printArray(ints);
    }
}

