package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p88;

/**
 * 爬楼梯的最少成本
 */
public class ClimbStairCost {

    /**
     * 比较直观算法实现 效率低
     *
     * @param cost 成本信息
     * @return 最小成本
     */
    public static int minCostClimbStairsL4(int[] cost) {
        return Math.min(helperL4(cost, cost.length - 2), helperL4(cost, cost.length - 1));
    }

    /**
     * 计算体
     *
     * @param cost 成本信息
     * @param i    索引
     * @return 成本
     */
    private static int helperL4(int[] cost, int i) {
        if (i < 2) {
            return cost[i];
        }
        return Math.min(helperL4(cost, i - 2), helperL4(cost, i - 1)) + cost[i];
    }

    /**
     * 比较直观算法实现 效率低
     *
     * @param cost 成本信息
     * @return 最小成本
     */
    public static int minCostClimbStairsL3(int[] cost) {
        int[] dp = new int[cost.length];
        helperL3(cost, cost.length - 1, dp);
        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }

    /**
     * 计算体
     *
     * @param cost 成本信息
     * @param i    索引
     * @param dp   缓存
     */
    private static void helperL3(int[] cost, int i, int[] dp) {
        if (i < 2) {
            dp[i] = cost[i];
        } else if (dp[i] == 0) {
            helperL3(cost, i - 2, dp);
            helperL3(cost, i - 1, dp);
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
    }

    /**
     * 动态规划
     *
     * @param cost 成本信息
     */
    public static int minCostClimbStairsL2(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }

    /**
     * 动态规划
     *
     * @param cost 成本信息
     */
    public static int minCostClimbStairsL1(int[] cost) {
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 100, 1};
        System.out.println("L4计算消耗成本：" + minCostClimbStairsL4(cost));
        System.out.println("L3计算消耗成本：" + minCostClimbStairsL3(cost));
        System.out.println("L2计算消耗成本：" + minCostClimbStairsL2(cost));
        System.out.println("L1计算消耗成本：" + minCostClimbStairsL1(cost));
    }
}
