package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 矩阵不同路径
 */
public class DifferentPathMatrix {

    /**
     * 矩阵不同路径（动态规划）
     *
     * @param m 行
     * @param n 列
     * @return 矩阵不同路径个数
     */
    public static int uniquePaths(int m, int n) {
        // 缓存路径个数
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 边缘处置1
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // 状态转移方程
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
