package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p99;

/**
 * 最小路径之和
 */
public class MiniPath {

    /**
     * 最小路径之和
     *
     * @param paths 路径信息
     * @return 最小路径之和
     */
    public static int miniPath(int[][] paths) {
        int row = paths.length;
        int col = paths[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = paths[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + paths[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + paths[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + paths[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] paths = {{1, 3, 1}, {2, 5, 2}, {3, 4, 1}};
        System.out.println(miniPath(paths));
    }

}
