package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

/**
 * 乘积最大子数组
 */
public class MaxProduct {

    /**
     * 乘积最大子数组
     *
     * @param numbers 数组
     * @return 乘积最大子数组
     */
    public static int maxProduct(int[] numbers) {
        int[][] dp = new int[2][numbers.length];
        System.arraycopy(numbers, 0, dp[0], 0, numbers.length);
        System.arraycopy(numbers, 0, dp[1], 0, numbers.length);
        for (int i = 1; i < numbers.length; ++i) {
            dp[0][i] = Math.max(dp[0][i - 1] * numbers[i], Math.max(numbers[i], dp[1][i - 1] * numbers[i]));
            dp[1][i] = Math.min(dp[1][i - 1] * numbers[i], Math.min(numbers[i], dp[0][i - 1] * numbers[i]));
        }
        int ans = dp[0][0];
        for (int i = 1; i < numbers.length; ++i) {
            ans = Math.max(ans, dp[0][i]);
        }
        return ans;
    }

    /**
     * 乘积最大子数组
     *
     * @param numbers 数组
     * @return 乘积最大子数组
     */
    public int maxProductL0(int[] numbers) {
        // 最大、小值、最大乘积
        int max = numbers[0], min = numbers[0], ans = numbers[0];
        for (int i = 1; i < numbers.length; ++i) {
            //  缓存
            int mx = max, mn = min;
            // 计算最大值
            max = Math.max(mx * numbers[i], Math.max(numbers[i], mn * numbers[i]));
            // 计算最小值
            min = Math.min(mn * numbers[i], Math.min(numbers[i], mx * numbers[i]));
            // 最大乘积
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
