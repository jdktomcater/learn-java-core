package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

/**
 * 爬楼梯
 */
public class ClimbStairs {

    /**
     * 爬楼梯
     *
     * @param n 楼梯数
     * @return 爬楼梯方案数
     */
    public static int climbStairsL0(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 爬楼梯
     *
     * @param n 楼梯数
     * @return 爬楼梯方案数
     */
    public static int climbStairsL1(int n) {
        if(n<2){
            return 1;
        }
        int step1 = 1, step2 = 1,step = 0;
        for (int i = 2; i <= n; i++) {
            step = step1 + step2;
            step1 = step2;
            step2 = step;
        }
        return step;
    }

}
