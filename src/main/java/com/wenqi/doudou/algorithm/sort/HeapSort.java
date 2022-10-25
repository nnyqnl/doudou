package com.wenqi.doudou.algorithm.sort;

import java.util.Arrays;

import static com.wenqi.doudou.algorithm.sort.QuickSort.*;

public class HeapSort {

    // 额外空间复杂度O(1)
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 使arr变成大根堆
//        for (int i = 0; i < arr.length; i++) { // O(n)
//            heapInsert(arr, i); // O(log(n))
//        }

        // O(n)
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;

        while (heapSize > 1) { // O(n)
            swap(arr, 0, heapSize - 1); // O(1)
            heapify(arr, 0, --heapSize); // O(log(n))
        }

    }

    private static void heapify(int[] heap, int i, int heapSize) {
        int left = 2 * i + 1;
        while (left < heapSize) {
            int currentMaxIndex = (left + 1) < heapSize && heap[left] < heap[left + 1]
                    ? left + 1 : left;
            currentMaxIndex = heap[i] > heap[currentMaxIndex] ? i : currentMaxIndex;
            if (currentMaxIndex == i) {
                break;
            }
            swap(heap, i, currentMaxIndex);
            i = currentMaxIndex;
            left = 2 * currentMaxIndex + 1;
        }
    }

    private static void heapInsert(int[] heap, int i) {
        while (heap[i] > heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            Arrays.sort(arr1);
            heapSort(arr2);

            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }

        }
        System.out.println(succeed ? "Nice!" : "Oops!");
    }
}
