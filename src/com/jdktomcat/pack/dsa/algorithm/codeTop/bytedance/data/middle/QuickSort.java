package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 排序
     *
     * @param numbers 目标数组
     * @return 排序数组
     */
    public static int[] sortArray(int[] numbers) {
        return quickSort(numbers, 0, numbers.length - 1);
    }

    /**
     * 排序
     *
     * @param numbers 目标数组
     * @return 排序数组
     */
    public static int[] quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int pivot = pivot(numbers, start, end);
            quickSort(numbers, start, pivot - 1);
            quickSort(numbers, pivot + 1, end);
        }
        return numbers;
    }

    /**
     * 分区
     *
     * @param numbers 目标数组
     * @param start   开始索引
     * @param end     结束索引
     * @return 区分索引
     */
    public static int pivot(int[] numbers, int start, int end) {
        int left = start, right = end + 1, target = numbers[start];
        while (true) {
            while (left < end && numbers[++left] < target) ;
            while (right > start && numbers[--right] > target) ;
            if (left < right) {
                swap(numbers, left, right);
            } else {
                break;
            }
        }
        swap(numbers, start, right);
        return right;
    }

    /**
     * 交换
     *
     * @param numbers 数组
     * @param i       索引1
     * @param j       索引2
     */
    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(numbers)));
    }
}
