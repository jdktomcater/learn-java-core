package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p101;

import java.util.Arrays;

/**
 * 分割等和子集
 */
public class DivideEqualSubGroup {

    /**
     * 判断是否可以分割
     *
     * @param numbers 数组
     * @return true：可分 false：不可分
     */
    public static boolean canPartition(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        if (sum % 2 == 1) {
            return false;
        }
        return subsetSumL0(numbers, sum / 2);
    }

    /**
     * 判断集合中是否有和为sum的
     *
     * @param numbers 数组
     * @param sum     目标值
     * @return true：有 false：没有
     */
    private static boolean subsetSumL1(int[] numbers, int sum) {
        boolean[][] dp = new boolean[numbers.length + 1][sum + 1];
        for (int i = 0; i <= numbers.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= numbers.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (!dp[i][j] && j >= numbers[i - 1]) {
                    dp[i][j] = dp[i - 1][j - numbers[i - 1]];
                }
            }
        }
        return dp[numbers.length][sum];
    }

    /**
     * 判断集合中是否有和为sum的
     *
     * @param numbers 数组
     * @param sum     目标值
     * @return true：有 false：没有
     */
    private static boolean subsetSumL0(int[] numbers, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= numbers.length; i++) {
            for (int j = sum; j > 0; j--) {
                if (!dp[j] && j >= numbers[i - 1]) {
                    dp[j] = dp[j - numbers[i - 1]];
                }
            }
        }
        return dp[sum];
    }

    /**
     * 判断集合中是否有和为sum的
     *
     * @param numbers 数组
     * @param sum     目标值
     * @return true：有 false：没有
     */
    private static boolean subsetSumL2(int[] numbers, int sum) {
        Boolean[][] dp = new Boolean[numbers.length + 1][sum + 1];
        return helper(numbers, dp, numbers.length, sum);
    }

    /**
     * 判断逻辑
     *
     * @param numbers 数组
     * @param dp      动态缓存
     * @param i       索引1
     * @param j       索引2
     * @return true：是 false：否
     */
    private static boolean helper(int[] numbers, Boolean[][] dp, int i, int j) {
        if (dp[i][j] == null) {
            if (j == 0) {
                dp[i][j] = true;
            } else if (i == 0) {
                dp[i][j] = false;
            } else {
                dp[i][j] = helper(numbers, dp, i - 1, j);
                if (!dp[i][j] && j >= numbers[i - 1]) {
                    dp[i][j] = helper(numbers, dp, i - 1, j - numbers[i - 1]);
                }
            }
        }
        return dp[i][j];
    }


    public static void main(String[] args) {
        int[] numbers1 = new int[]{3, 4, 1};
        int[] numbers2 = new int[]{1, 2, 3, 5};
        System.out.println(canPartition(numbers1));
        System.out.println(canPartition(numbers2));
    }

}
