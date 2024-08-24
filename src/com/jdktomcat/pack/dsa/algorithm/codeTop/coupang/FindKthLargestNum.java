package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 查找第k大元素
 */
public class FindKthLargestNum {

    /**
     * 查找第k大元素
     *
     * @param numbers 目标数组
     * @param k       阈值
     * @return 目标值
     */
    public static int findKthLargest(int[] numbers, int k) {
        int start = 0, end = numbers.length - 1;
        while (start <= end) {
            int pivot = pivot(numbers, start, end);
            if (pivot + k == numbers.length) {
                return numbers[pivot];
            } else if (pivot + k < numbers.length) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }
        return -1;
    }

    /**
     * 计算分割索引，使得索引前数据小于索引后数据
     *
     * @param numbers 数组
     * @param start   起始索引
     * @param end     截止索引
     * @return 分割索引
     */
    private static int pivot(int[] numbers, int start, int end) {
        int target = numbers[start];
        int left = start;
        int right = end + 1;
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
     * @param i       下标1
     * @param j       下标2
     */
    private static void swap(int[] numbers, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
