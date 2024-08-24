package com.jdktomcat.pack.dsa.algorithm.company.xiaomi.mid;

import java.util.List;

/**
 * 最小三角形和
 */
public class MinTriangleSum {

    /**
     * 最小三角形和
     *
     * @param triangle 数据信息
     * @return 最小三角形和
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }

    public static int minimumTotalL0(List<List<Integer>> triangle) {
        List<Integer> root = triangle.get(0);
        int[] min = {Integer.MAX_VALUE};
        for (int i = 0; i < root.size(); i++) {
            dfs(triangle, 1, i, root.get(i), min);
        }
        return min[0];
    }

    private static void dfs(List<List<Integer>> triangle, int level, int index, int sum, int[] min) {
        if (level == triangle.size()) {
            min[0] = Math.min(sum, min[0]);
        } else {
            dfs(triangle, level + 1, index, triangle.get(level).get(index) + sum, min);
            dfs(triangle, level + 1, index + 1, triangle.get(level).get(index + 1) + sum, min);
        }
    }

    public static int minimumTotalL1(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 动态规划
     *
     * @param triangle 三角形信息
     * @return 三角形和最小
     */
    public static int minimumTotalL2(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
