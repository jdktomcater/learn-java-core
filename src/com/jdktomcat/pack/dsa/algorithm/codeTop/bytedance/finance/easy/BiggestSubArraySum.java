package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

/**
 * 最大子数组和
 */
public class BiggestSubArraySum {

    /**
     * 最大子数组和
     *
     * @param numbers 数组
     * @return 最大子数组和
     */
    public static int maxSubArray(int[] numbers) {
        int pre = 0, max = 0;
        for (int number : numbers) {
            pre = Math.max(pre + number, number);
            max = Math.max(max, pre);
        }
        return max;
    }

}
