package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p76;

import com.jdktomcat.pack.dsa.algorithm.book.offer.util.SwapUtil;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param numbers 目标数组
     * @param start   开始索引
     * @param end     截止索引
     */
    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int pivot = partition(numbers, start, end);
            quickSort(numbers, start, pivot - 1);
            quickSort(numbers, pivot + 1, end);
        }
    }

    /**
     * 查找分割点
     *
     * @param numbers 目标数组
     * @param start   开始索引
     * @param end     截止索引
     * @return 分割点索引
     */
    public static int partition(int[] numbers, int start, int end) {
        int left = start;
        int right = end + 1;
        int target = numbers[start];
        while (true) {
            while (left < end && numbers[++left] < target) ;
            while (right > start && numbers[--right] > target) ;
            if (left < right) {
                SwapUtil.swap(numbers, left, right);
            } else {
                break;
            }
        }
        SwapUtil.swap(numbers, start, right);
        return right;
    }
}
