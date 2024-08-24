package com.jdktomcat.pack;

import java.util.Arrays;

public class QuickSort {

    /**
     * 交换数组中两个下标数值
     *
     * @param data       数组
     * @param leftIndex  左索引
     * @param rightIndex 右索引
     */
    private static void swap(int[] data, int leftIndex, int rightIndex) {
        int temp = data[leftIndex];
        data[leftIndex] = data[rightIndex];
        data[rightIndex] = temp;
    }

    /**
     * 快速排序
     *
     * @param data  目标数组
     * @param start 起始索引
     * @param end   结束索引
     */
    public static void sort(int[] data, int start, int end) {
        if (start < end) {
            int pivot = pivot(data, start, end);
            sort(data, start, pivot - 1);
            sort(data, pivot + 1, end);
        }
    }

    private static int pivot(int[] data, int start, int end) {
        int target = data[start];
        int left = start;
        int right = end + 1;
        while (true) {
            while (left < data.length - 1 && target > data[++left]) ;
            while (right >= 0 && target < data[--right]) ;
            if (left < right) {
                swap(data, left, right);
            } else {
                break;
            }
        }
        swap(data, start, right);
        return right;
    }


    public static void main(String[] args) {
        int[] data = new int[]{10, 15, 564, 123, 566, 21, 34, 6, 3, 12, 7895, 7, 345};
        System.out.println("before sort:" + Arrays.toString(data));
        sort(data, 0, data.length - 1);
        System.out.println("after sort:" + Arrays.toString(data));
    }
}
