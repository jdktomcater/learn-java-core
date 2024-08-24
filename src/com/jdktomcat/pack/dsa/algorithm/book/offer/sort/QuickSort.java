package com.jdktomcat.pack.dsa.algorithm.book.offer.sort;

import com.jdktomcat.pack.dsa.algorithm.book.offer.util.SwapUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 快速排序旧
     *
     * @param nums  目标数组
     * @param start 起始索引
     * @param end   截止索引
     */
    public static void quickSortOld(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = nums[start];
            int left = start;
            int right = end + 1;
            while (true) {
                while (left <= end && nums[++left] < pivot) ;
                while (right >= start && nums[--right] > pivot) ;
                if (left < right) {
                    SwapUtil.swap(nums, left, right);
                } else {
                    break;
                }
            }
            SwapUtil.swap(nums, start, right);
            quickSortOld(nums, start, right - 1);
            quickSortOld(nums, right + 1, end);
        }
    }

    /**
     * 分区，计算目标下标
     *
     * @param nums  目标数组
     * @param start 起始索引
     * @param end   截止索引
     * @return 目标索引
     */
    public static int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        SwapUtil.swap(nums, random, end);
        int small = start - 1;
        for (int index = start; index < end; index++) {
            if (nums[index] < nums[end]) {
                small++;
                SwapUtil.swap(nums, index, small);
            }
        }
        small++;
        SwapUtil.swap(nums, small, end);
        return small;
    }

    /**
     * 新版快速排序
     *
     * @param nums  数组
     * @param start 开始索引
     * @param end   截止索引
     */
    public static void quickSortNew(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            quickSortNew(nums, start, pivot - 1);
            quickSortNew(nums, pivot + 1, end);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 8, 1, 7, 2, 3};
        quickSortNew(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }


}
