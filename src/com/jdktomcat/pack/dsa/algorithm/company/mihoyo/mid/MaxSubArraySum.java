package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

/**
 * 最大子数组和
 */
public class MaxSubArraySum {

    /**
     * 最大子数组和
     *
     * @param numbers 数组
     * @return 最大子数组和
     */
    public static int maxSubArray(int[] numbers) {
        int pre = numbers[0], max = numbers[0];
        for (int number : numbers) {
            pre = Math.max(number, pre + number);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(numbers));
    }
}
