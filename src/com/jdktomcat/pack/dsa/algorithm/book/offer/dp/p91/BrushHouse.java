package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p91;

/**
 * 粉刷房子问题
 */
public class BrushHouse {

    /**
     * 最小花费
     *
     * @param costs 花费详情
     * @return 最小花费
     */
    public static int miniCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[3][2];
        // 颜色初始值
        for (int i = 0; i < 3; i++) {
            dp[i][0] = costs[0][i];
        }
        // 花费遍历
        for (int i = 1; i < costs.length; i++) {
            // 颜色遍历
            for (int j = 0; j < 3; j++) {
                // 取另外两种颜色花费最小者然后加上该颜色花费
                dp[j][i % 2] = Math.min(dp[(j + 2) % 3][(i - 1) % 2], dp[(j + 1) % 3][(i - 1) % 2]) + costs[i][j];
            }
        }
        // 计算索引
        int last = (costs.length - 1) % 2;
        // 取三者最小者即可
        return Math.min(dp[0][last], Math.min(dp[1][last], dp[2][last]));
    }
}
