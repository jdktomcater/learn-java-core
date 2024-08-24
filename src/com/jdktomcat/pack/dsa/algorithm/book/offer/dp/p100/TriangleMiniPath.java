package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p100;

import java.util.List;

/**
 * 三角形最小路径
 */
public class TriangleMiniPath {

    /**
     * 最小路径和
     *
     * @param triangle 三角形信息
     * @return 最小路径和
     */
    public static int minimumTotalL1(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (i > 0 && j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (i > 0 && i == j) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else if (i > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[size - 1]) {
            min = Math.min(min, num);
        }
        return min;
    }

    /**
     * 最小路径和
     *
     * @param triangle 三角形信息
     * @return 最小路径和
     */
    public static int minimumTotalL0(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        for (List<Integer> row : triangle) {
            for (int j = row.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] += row.get(j);
                } else if (row.size() - 1 == j) {
                    dp[j] = dp[j - 1] + row.get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + row.get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            min = Math.min(min, num);
        }
        return min;
    }
}
