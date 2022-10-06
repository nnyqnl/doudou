package com.wenqi.doudou.algorithm.linklist;

/**
 * 求数组的小和
 * 何为小和：数组中每个元素左边比他小的数加起来
 */
public class Code09_SmallSum {

    //利用归并排序

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        return process(arr, left, mid)
                + process(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
            tempArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p2 <= right) {
            tempArr[i++] = arr[p2++];
        }

        while (p1 <= mid) {
            tempArr[i++] = arr[p1++];
        }

        for (i = 0; i < tempArr.length; i++) {
            arr[i + left] = tempArr[i];
        }
        return res;
    }

    public static int smallSum2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    res += arr[j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int smallSum = smallSum(arr1);
            int smallSum2 = smallSum2(arr2);
            if (smallSum != smallSum2) {
                succeed = false;
                break;
            }

        }
        System.out.println(succeed ? "Nice!" : "Oops!");
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
