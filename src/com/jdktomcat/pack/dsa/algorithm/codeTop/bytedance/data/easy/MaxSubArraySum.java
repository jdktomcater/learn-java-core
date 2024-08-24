package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.easy;

/**
 * 最大连续子数组
 */
public class MaxSubArraySum {

    /**
     * 最大连续子数组和
     *
     * @param numbers 数组
     * @return 最大和
     */
    public static int maxSubArray(int[] numbers) {
        int pre = 0, max = numbers[0];
        for (int number : numbers) {
            pre = Math.max(pre + number, number);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(numbers));
    }
}
