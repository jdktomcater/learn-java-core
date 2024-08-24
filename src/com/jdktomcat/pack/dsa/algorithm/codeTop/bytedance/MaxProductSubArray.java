package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 乘积最大子数组
 */
public class MaxProductSubArray {

    /**
     * 乘积最大子数组
     *
     * @param numbers 目标数组
     * @return 最大乘积
     */
    public static int maxProduct(int[] numbers) {
        int[] dp = new int[numbers.length + 1];
        dp[0] = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int max = numbers[i], product = numbers[i];
            for (int j = i - 1; j >= 0; j--) {
                product *= numbers[j];
                max = Math.max(max, product);
            }
            dp[i + 1] = Math.max(dp[i], max);
        }
        return dp[numbers.length];
    }

    /**
     * 乘积最大子数组
     *
     * @param numbers 目标数组
     * @return 最大乘积
     */
    public static int maxProductL0(int[] numbers) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int max = numbers[i], product = numbers[i];
            for (int j = i - 1; j >= 0; j--) {
                product *= numbers[j];
                max = Math.max(max, product);
            }
            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }

    /**
     * 乘积最大子数组
     *
     * @param numbers 目标数组
     * @return 最大乘积
     */
    public static int maxProductL1(int[] numbers) {
        int length = numbers.length;
        int[][] dp = new int[2][length];
        System.arraycopy(numbers, 0, dp[0], 0, length);
        System.arraycopy(numbers, 0, dp[1], 0, length);
        for (int i = 1; i < length; ++i) {
            dp[0][i] = Math.max(dp[0][i - 1] * numbers[i], Math.max(numbers[i], dp[1][i - 1] * numbers[i]));
            dp[1][i] = Math.min(dp[1][i - 1] * numbers[i], Math.min(numbers[i], dp[0][i - 1] * numbers[i]));
        }
        int ans = dp[0][0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, dp[0][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, -2, -9, -6};
        System.out.println(maxProductL1(numbers));
    }
}
