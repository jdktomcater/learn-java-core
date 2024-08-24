package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p102;

import java.util.Arrays;

/**
 * 加减的目标值
 */
public class AddDeleteTarget {

    /**
     * 查找途径数目
     *
     * @param numbers 目标数组
     * @param target  目标值
     * @return 途径数目
     */
    public static int findTargetSumWays(int[] numbers, int target) {
        int sum = Arrays.stream(numbers).sum();
        if ((sum + target) % 2 == 1 || sum < target) {
            return 0;
        }
        return subsetSum(numbers, (sum + target) / 2);
    }

    /**
     * 计算路径数量
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 路径数量
     */
    private static int subsetSum(int[] numbers, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int number : numbers) {
            for (int j = target; j >= number; j--) {
                dp[j] += dp[j - number];
            }
        }
        return dp[target];
    }
}
