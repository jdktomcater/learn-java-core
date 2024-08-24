package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 圆环移动相关问题
 */
public class CycleMoveIssue {

    /**
     * 圆环移动返回走法
     *
     * @param dots 点数
     * @param step 步数
     * @return 圆环移动返回走法
     */
    public static int backToOrigin(int dots, int step) {
        int[][] dp = new int[step + 1][dots];
        dp[0][0] = 1;
        for (int i = 1; i <= step; i++) {
            for (int j = 0; j < dots; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + dots) % dots] + dp[i - 1][(j + 1) % dots];
            }
        }
        return dp[step][0];
    }

    public static void main(String[] args) {
        int dots = 10;
        int step = 2;
        System.out.println(backToOrigin(dots, step));
    }

}
