package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p98;

import java.util.Arrays;

/**
 * 路径数目
 */
public class PathNumber {

    /**
     * 计算路径数目
     *
     * @param m 行
     * @param n 列
     * @return 路径数目
     */
    public static int pathCount(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 路径数目
     *
     * @param m 行
     * @param n 列
     * @return 路径数目
     */
    public static int uniquePathsL0(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 路径数目
     *
     * @param m 行
     * @param n 列
     * @return 路径数目
     */
    public static int uniquePathsL1(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(m - 1, n - 1, dp);
    }

    /**
     * 计算逻辑
     *
     * @param i  行
     * @param j  列
     * @param dp 动态缓存
     * @return 结果
     */
    private static int helper(int i, int j, int[][] dp) {
        if (dp[i][j] == 0) {
            if (i == 0 || j == 0) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = helper(i - 1, j, dp) + helper(i, j - 1, dp);
            }
        }
        return dp[i][j];
    }


    public static void main(String[] args) {
        System.out.println(pathCount(3, 3));
        System.out.println(uniquePathsL0(3, 3));
        System.out.println(uniquePathsL1(10, 3));
    }

}
