package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

import java.util.Arrays;

/**
 * 龙与地下城游戏问题
 */
public class DragonAndUnderCityIssue {

    /**
     * 必需最小能量
     *
     * @param map 地图信息
     * @return 最小能量
     */
    public static int minPower0(int[][] map) {
        int row = map.length, col = map[0].length;
        int[][] dp = new int[row][col];
        for (int[] r : dp) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        dp[row - 1][col - 1] = map[row - 1][col - 1] > 0 ? 1 : 1 - map[row - 1][col - 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i > 0) {
                    dp[i - 1][j] = Math.min(dp[i - 1][j], Math.max(dp[i][j] - map[i - 1][j], 1));
                }
                if (j > 0) {
                    dp[i][j - 1] = Math.min(dp[i][j - 1], Math.max(dp[i][j] - map[i][j - 1], 1));
                }
            }
        }
        return dp[0][0];
    }

    public static int minPower1(int[][] map) {
        int[] min = {Integer.MAX_VALUE};
        int row = map.length, col = map[0].length;
        int p = map[row - 1][col - 1] > 0 ? 1 : 1 - map[row - 1][col - 1];
        dfs(map, row - 1, col - 1, p, min);
        return min[0];
    }

    private static void dfs(int[][] map, int i, int j, int power, int[] min) {
        if (i == 0 && j == 0) {
            min[0] = Math.min(power, min[0]);
        } else if (i >= 0 && j >= 0) {
            if (i > 0) {
                dfs(map, i - 1, j, Math.max(power - map[i - 1][j], 1), min);
            }
            if (j > 0) {
                dfs(map, i, j - 1, Math.max(power - map[i][j - 1], 1), min);
            }
        }
    }


    public static void main(String[] args) {
        int[][] map = {{0, -5}, {0, 0}};
        System.out.println(minPower0(map));
    }

}
