package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

/**
 * 最长递增子序列
 */
public class LengthOfLIS {

    /**
     * 最长递增子序列
     *
     * @param numbers 数组
     * @return 最长递增子序列
     */
    public static int lengthOfLIS(int[] numbers) {
        // 缓存最长长度
        int[] dp = new int[numbers.length];
        // 边界值
        dp[0] = 1;
        int max = 1;
        // 双层循环
        for (int i = 1; i < numbers.length; i++) {
            // 初始值
            dp[i] = 1;
            // 内循环
            for (int j = 0; j < i; j++) {
                // 当外层大于内层
                if (numbers[i] > numbers[j]) {
                    // 动态方程
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
