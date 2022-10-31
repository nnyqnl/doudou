package com.wenqi.doudou.algorithm.heap;

import java.util.*;

/**
 * 实现堆的resign方法
 */
public class Heap02 {
    public static class MyHeap<T> {

        private ArrayList<T> heap;
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<T> comparator;

        public MyHeap(Comparator<T> comparator) {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            this.comparator = comparator;
        }


        public void push(T o) {
            heap.add(o);
            indexMap.put(o, heapSize);
            heapInsert(heapSize++);
        }

        public void resign(T o) {
            Integer index = indexMap.get(o);
            heapInsert(index);
            heapify(index);

        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("heap is empty");
            }
            T res = heap.get(0);
            heap.set(0, heap.get(--heapSize));
            heapify(0);
            return res;
        }

        private void heapInsert(int i) {
            while (comparator.compare(heap.get(i), heap.get((i - 1) / 2)) < 0) {
                swap(heap, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            while (left < heapSize) {
                int minIndex = (left + 1) < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0
                        ? left + 1 : left;
                minIndex = comparator.compare(heap.get(i), heap.get(minIndex)) < 0 ? i : minIndex;
                if (minIndex == i) {
                    break;
                }
                swap(heap, i, minIndex);
                i = minIndex;
                left = 2 * minIndex + 1;
            }
        }

        private boolean isEmpty() {
            return heapSize == 0;
        }


        public void swap(ArrayList<T> arr, int index1, int index2) {
            T temp = arr.get(index1);
            arr.set(index1, arr.get(index2));
            arr.set(index2, temp);

            indexMap.put(arr.get(index1), index1);
            indexMap.put(arr.get(index2), index2);
        }


    }

    static class Student {
        private int age;

        public Student(int age) {
            this.age = age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
        //        @Override
//        public String toString() {
//            return "Student{" +
//                    "age=" + age +
//                    '}';
//        }
    }

    public static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

//    public static void main(String[] args) {
//
//        // 对数器
//        System.out.println("test begin");
//        int maxValue = 100000;
//        int pushTime = 1000000;
//        int resignTime = 100;
//        MyHeap<Student> test = new MyHeap<>(new StudentComparator());
//        ArrayList<Student> list = new ArrayList<>();
//        for (int i = 0; i < pushTime; i++) {
//            Student cur = new Student((int) (Math.random() * maxValue));
//            list.add(cur);
//            test.push(cur);
//        }
//        for (int i = 0; i < resignTime; i++) {
//            int index = (int) (Math.random() * pushTime);
//            list.get(index).age = (int) (Math.random() * maxValue);
//            test.resign(list.get(index));
//        }
//        int preAge = Integer.MIN_VALUE;
//        while (!test.isEmpty()) {
//            Student cur = test.pop();
//            if (cur.age < preAge) {
//                System.out.println("Oops!");
//            }
//            preAge = cur.age;
//        }
//        System.out.println("test finish");
//
//    }

    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyHeap<Student> my = new MyHeap<>(new StudentComparator());
            int curOpTimes = (int) (Math.random() * limit);
            Student[] arr = new Student[curOpTimes];
            for (int j = 0; j < curOpTimes; j++) {
                // 产生curOpTimes个随机的Student, 加入到MyHeap, 在resign n个， 再把MyHeap中到元素加到 rightHeap, 比较
                int age = (int) (Math.random() * value);
                Student student = new Student(age);
                my.push(student);
                arr[j] = student;
            }
            for (int k = 0; k < (int) (Math.random() * curOpTimes); k++) {
                Student student = arr[(int) (Math.random() * curOpTimes)];
                student.setAge((int) (Math.random() * value));
                my.resign(student);
            }

            int pre = 0;
            while (!my.isEmpty()) {
                Student pop = my.pop();
                if (pop.getAge() < pre) {
                    System.out.println("Fuck...");
                }
                pre = pop.getAge();
            }

        }

        System.out.println("finish!");

    }
}
