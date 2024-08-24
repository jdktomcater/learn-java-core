package com.jdktomcat.pack.dsa.algorithm.codeTop.ks;

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class LongestOfLIS {

    /**
     * 最长递增子序列长度
     *
     * @param numbers 目标数组
     * @return 最长递增子序列长度
     */
    public static int longestOfLIS(int[] numbers) {
        int[] dp = new int[numbers.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(longestOfLIS(numbers));
    }

}
