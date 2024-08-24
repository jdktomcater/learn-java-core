package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;

/**
 * 最小路径和
 */
public class MinPathMatrix {

    /**
     * 最小路径和
     *
     * @param grid 表格
     * @return 最小路径和
     */
    public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < r; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < c; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[r - 1][c - 1];
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid1));
        int[][] grid2 = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid2));

    }

}
