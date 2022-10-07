package com.wenqi.doudou.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) return;
        int i = partition(arr, L, R);
        process(arr, L, i - 1);
        process(arr, i + 1, R);
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    private static void process2(int[] arr, int L, int R) {
        if (L >= R) return;
        int[] ints = netherlandsFlag(arr, L, R);
        process2(arr, L, ints[0] - 1);
        process2(arr, ints[1] + 1, R);
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    private static void process3(int[] arr, int L, int R) {
        if (L >= R) return;
        swap(arr, R, L + (int) (Math.random() * (R - L + 1)));
        int[] ints = netherlandsFlag(arr, L, R);
        process3(arr, L, ints[0] - 1);
        process3(arr, ints[1] + 1, R);
    }

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
        return new int[]{less + 1, more - 1};
    }

    /**
     * 返回以R为边界，小于R的放左边，否则放右边，返回右边界的第一个数
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
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
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int[] arr4 = copyArray(arr1);
            Arrays.sort(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            quickSort(arr4);

            if (!isEqual(arr1, arr2) && !isEqual(arr1, arr3) && !isEqual(arr1, arr4)) {
                succeed = false;
                break;
            }

        }
        System.out.println(succeed ? "Nice!" : "Oops!");
    }


    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
