package com.jdktomcat.pack.dsa.algorithm.book.offer.array.p6;

import java.util.Arrays;

/**
 * 排序数组中的两个数字之和
 */
public class SortedArraySumTarget {

    /**
     * 排序数组中的两个数字之和为目标值下标
     *
     * @param numbers 数组
     * @param target  目标和
     * @return 下标
     */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                ++i;
            } else {
                --j;
            }
        }
        return new int[]{i, j};
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 6, 10};
        int target = 8;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

}
