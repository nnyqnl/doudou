package com.wenqi.doudou.algorithm.heap;

import com.wenqi.doudou.algorithm.utils.Util;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给一个不完全有序的数组，该数组特征是，如果使他有序，每一个元素移动的位置不超过k
 */
public class Code02_SortArrayDistanceLessK {

    public static void sortArrayDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;
        int minI = 0;
        while (i < arr.length) {
            if (minHeap.size() < k + 1) {
                minHeap.add(arr[i++]);
            }

            if (minHeap.size() == k + 1) {
                arr[minI++] = minHeap.poll();
            }
        }

        while (minHeap.size() > 0) {
            arr[minI++] = minHeap.poll();
        }
    }


    // for test
    public static int[] randomArrayNoMoveMoreK(int maxSize, int maxValue, int K) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        // 先排个序
        Arrays.sort(arr);
        // 然后开始随意交换，但是保证每个数距离不超过K
        // swap[i] == true, 表示i位置已经参与过交换
        // swap[i] == false, 表示i位置没有参与过交换
        boolean[] isSwap = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = Math.min(i + (int) (Math.random() * (K + 1)), arr.length - 1);
            if (!isSwap[i] && !isSwap[j]) {
                isSwap[i] = true;
                isSwap[j] = true;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100000; i++) {
            int k = 10;
            int[] arr = randomArrayNoMoveMoreK(100, 100, k);
            int[] copyArray = Util.copyArray(arr);

            sortArrayDistanceLessK(arr, k);
            Arrays.sort(copyArray);

            if (!Util.isEqual(arr, copyArray)) {
                System.out.println("Fuck...");
            }
        }

        System.out.println("Nice...");

    }
}
