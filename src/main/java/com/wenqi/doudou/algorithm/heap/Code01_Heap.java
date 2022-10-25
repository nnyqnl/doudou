package com.wenqi.doudou.algorithm.heap;

public class Code01_Heap {

    public static class MyMaxHeap {
        private final int[] heap;
        private int heapSize;
        private final int limit;

        public int[] getHeap() {
            return heap;
        }

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;

        }

        public int getHeapSize() {
            return this.heapSize;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int a) {
            if (isFull()) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = a;
            heapInsert(heap, heapSize++);
        }

        public int pop() {
            int result = heap[0];
            heap[0] = heap[--heapSize];
            heapify(heap, 0, heapSize);
            return result;
        }

        private void heapify(int[] heap, int i, int heapSize) {
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

        private void heapInsert(int[] heap, int i) {
            while (heap[i] > heap[(i - 1) / 2]) {
                swap(heap, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        public void swap(int[] arr, int index1, int index2) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }


    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }


    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyMaxHeap my = new MyMaxHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");

    }

}
