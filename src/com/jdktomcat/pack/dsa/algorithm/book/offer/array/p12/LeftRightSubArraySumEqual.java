package com.jdktomcat.pack.dsa.algorithm.book.offer.array.p12;

import java.util.Arrays;

/**
 * 左右两边子数组的和相等
 */
public class LeftRightSubArraySumEqual {

    /**
     * 左右两边子数组的和相等索引
     *
     * @param numbers 数组
     * @return 左右两边子数组的和相等索引
     */
    public static int pivotIndex(int[] numbers) {
        int total = Arrays.stream(numbers).sum();
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (sum - numbers[i] == total - sum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 7, 3, 6, 2, 9};
        System.out.println(pivotIndex(numbers));
    }

}
