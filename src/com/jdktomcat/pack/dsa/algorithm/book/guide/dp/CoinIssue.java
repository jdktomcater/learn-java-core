package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

import java.util.Arrays;

/**
 * 硬币相关问题
 */
public class CoinIssue {

    /**
     * 换零钱（回溯递归暴力破解）
     *
     * @param coins  硬币数组
     * @param target 目标面值
     * @return 最少硬币数量
     */
    public static int minCoins1(int[] coins, int target) {
        if (coins == null || coins.length == 0 || target < 0) {
            return -1;
        }
        return charge(coins, 0, target);
    }

    /**
     * 换零钱
     *
     * @param coins  硬币数组
     * @param index  索引
     * @param target 剩余钱数
     * @return 最小硬币数
     */
    private static int charge(int[] coins, int index, int target) {
        if (index == coins.length) {
            return target == 0 ? 0 : -1;
        }
        int rest = -1;
        for (int k = 0; k * coins[index] <= target; k++) {
            int next = charge(coins, index + 1, target - k * coins[index]);
            if (next != -1) {
                rest = rest == -1 ? next + k : Math.min(rest, next + k);
            }
        }
        return rest;
    }

    /**
     * 换零钱（回溯递归暴力破解）
     *
     * @param coins  硬币数组
     * @param target 目标面值
     * @return 最少硬币数量
     */
    public static int minCoins2(int[] coins, int target) {
        int[] min = {Integer.MAX_VALUE};
        dfs(coins, 0, 0, target, min);
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }

    /**
     * 深度计算逻辑
     *
     * @param coins  硬币数组
     * @param count  硬币数量
     * @param index  硬币索引
     * @param target 目标面值
     * @param min    最小结果
     */
    private static void dfs(int[] coins, int count, int index, int target, int[] min) {
        if (target == 0) {
            min[0] = Math.min(min[0], count);
        } else if (target > 0 && index < coins.length) {
            dfs(coins, count + 1, index, target - coins[index], min);
            dfs(coins, count, index + 1, target, min);
        }
    }

    /**
     * 换零钱（动态规划）
     *
     * @param coins  零钱数组
     * @param target 目标面值
     * @return 最少硬币数
     */
    private static int minCoins3(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int rst = 1; rst <= target; rst++) {
            for (int coin : coins) {
                if (rst >= coin) {
                    dp[rst] = Math.min(dp[rst], dp[rst - coin] + 1);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }

    /**
     * 换钱方法（回溯递归）
     *
     * @param coins  硬币数组
     * @param target 目标值
     * @return 方法总数
     */
    public static int count0(int[] coins, int target) {
        return dfsCount0(coins, 0, target);
    }

    /**
     * 深度统计
     *
     * @param coins  硬币数组
     * @param index  索引
     * @param target 目标值
     * @return 方法数
     */
    private static int dfsCount0(int[] coins, int index, int target) {
        if (target == 0) {
            return 1;
        } else if (index < coins.length && target > 0) {
            int include = dfsCount0(coins, index, target - coins[index]);
            int uninclude = dfsCount0(coins, index + 1, target);
            return include + uninclude;
        }
        return 0;
    }

    /**
     * 换钱方法（回溯递归）
     *
     * @param coins  硬币数组
     * @param target 目标值
     * @return 方法总数
     */
    public static int count1(int[] coins, int target) {
        int[][] dp = new int[coins.length + 1][target + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        return dfsCount1(coins, dp, 0, target);
    }

    /**
     * 深度统计
     *
     * @param coins  硬币数组
     * @param dp     缓存信息
     * @param index  索引
     * @param target 目标值
     * @return 方法数
     */
    private static int dfsCount1(int[] coins, int[][] dp, int index, int target) {
        if (target == 0) {
            return 1;
        } else if (index < coins.length && target > 0) {
            int include = 0;
            if (target >= coins[index]) {
                if (dp[index][target - coins[index]] != 0) {
                    include = dp[index][target - coins[index]];
                } else {
                    include = dfsCount1(coins, dp, index, target - coins[index]);
                }
            }
            int uninclude;
            if (dp[index + 1][target] != 0) {
                uninclude = dp[index + 1][target];
            } else {
                uninclude = dfsCount1(coins, dp, index + 1, target);
            }
            int sum = include + uninclude;
            dp[index][target] = sum;
            return sum;
        }
        return 0;
    }

    /**
     * 换钱方法（动态规划）
     *
     * @param coins  硬币数组
     * @param target 目标值
     * @return 方法总数
     */
    public static int count2(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; coins[0] * j <= target; j++) {
            dp[0][coins[0] * j] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                int num = 0;
                for (int k = 0; j - coins[i] * k >= 0; k++) {
                    num += dp[i - 1][j - coins[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[coins.length - 1][target];
    }

    /**
     * 换钱方法（动态规划）
     *
     * @param coins  硬币数组
     * @param target 目标值
     * @return 方法总数
     */
    public static int count3(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; coins[0] * j <= target; j++) {
            dp[0][coins[0] * j] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j] + (j - coins[i] >= 0 ? dp[i][j - coins[i]] : 0);
            }
        }
        return dp[coins.length - 1][target];
    }

    /**
     * 换钱方法（动态规划+空间压缩）
     *
     * @param coins  硬币数组
     * @param target 目标值
     * @return 方法总数
     */
    public static int count4(int[] coins, int target) {
        int[] dp = new int[target + 1];
        for (int j = 0; coins[0] * j <= target; j++) {
            dp[coins[0] * j] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[j] += j - coins[i] >= 0 ? dp[j - coins[i]] : 0;
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] coins = {5, 10, 25, 1};
        int target = 15;
        System.out.println(count4(coins, target));
    }
}
