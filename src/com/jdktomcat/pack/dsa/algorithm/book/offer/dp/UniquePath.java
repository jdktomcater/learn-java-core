package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;


import java.util.Arrays;

/**
 * 矩阵路径问题
 */
public class UniquePath {

    /**
     * 走路径数目
     *
     * @param m 长度
     * @param n 宽度
     * @return 数目
     */
    public static int uniquePath(int m, int n) {
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
     * 计算最小路径和
     *
     * @param grid 表格
     * @return 最小路径
     */
    public static int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int j = 1; j < dp.length; j++) {
            dp[j] = grid[0][j] + dp[j - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePath(3, 3));
    }
}
