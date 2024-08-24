package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param numbers 目标数组
     * @return 排序后结果
     */
    public static int[] sortArray(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    /**
     * 快速排序
     *
     * @param numbers 目标数组
     * @param start   起始下标
     * @param end     结束下标
     */
    private static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int pivot = pivot(numbers, start, end);
            quickSort(numbers, start, pivot - 1);
            quickSort(numbers, pivot + 1, end);
        }
    }

    /**
     * 计算基准点
     *
     * @param numbers 目标数组
     * @param start   起始下标
     * @param end     结束下标
     * @return 基准索引
     */
    private static int pivot(int[] numbers, int start, int end) {
        if (start < end) {
            int left = start;
            int right = end + 1;
            int target = numbers[start];
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
        return -1;
    }

    /**
     * 交换数组元素
     *
     * @param numbers 目标数组
     * @param i       下标1
     * @param j       下标2
     */
    private static void swap(int[] numbers, int i, int j) {
        if (i != j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(sortArray(numbers)));

    }

}
