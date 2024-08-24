package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 最大子数组和
 */
public class MaxSumSubArray {
    /**
     * 最大子数组和（动态规划）
     *
     * @param numbers 数组
     * @return 最大子数组和
     */
    public static int maxSubArray(int[] numbers) {
        // 缓存前一个值，最大和值
        int pre = 0, maxAns = numbers[0];
        // 遍历
        for (int number : numbers) {
            // 判断前值+目前值与现在值的大小,取大值
            pre = Math.max(pre + number, number);
            // 然后取大值
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    /**
     * 最大子数组和（动态规划）
     *
     * @param numbers 数组
     * @return 最大子数组和
     */
    public static int maxSubArrayL0(int[] numbers) {
        // 缓存前一个值，最大和值
        int[] dp = new int[numbers.length];
        int maxAns = numbers[0];
        dp[0] = 0;
        // 遍历
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

}
