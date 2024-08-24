package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {

    /**
     * 爬楼梯不同方法（动态规划）
     *
     * @param n 台阶数
     * @return 爬楼梯不同方法
     */
    public static int climbStairs(int n) {
        // 缓存爬楼梯不同方法数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 状态转移方程
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
