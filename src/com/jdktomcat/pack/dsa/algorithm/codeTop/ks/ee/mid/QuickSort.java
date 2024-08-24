package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param numbers 数组
     * @return 排序后数组
     */
    public static int[] sortArray(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    /**
     * 快速排序
     *
     * @param numbers 数组
     * @param start   开始索引
     * @param end     结束索引
     */
    private static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int pivot = pivot(numbers, start, end);
            quickSort(numbers, start, pivot - 1);
            quickSort(numbers, pivot + 1, end);
        }
    }

    /**
     * 获取基准点索引
     *
     * @param numbers 数组
     * @param start   开始索引
     * @param end     截止索引
     * @return 基准点索引
     */
    private static int pivot(int[] numbers, int start, int end) {
        int left = start, target = numbers[start], right = end + 1;
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

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {5,2,3,1};
        int[] sort = sortArray(numbers);
        System.out.println(Arrays.toString(sort));
    }
}
