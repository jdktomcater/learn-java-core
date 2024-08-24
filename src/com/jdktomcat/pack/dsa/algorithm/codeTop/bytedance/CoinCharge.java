package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.*;

/**
 * 换零钱
 */
public class CoinCharge {

    /**
     * 换零钱最少
     *
     * @param coins 零钱数
     * @param sum   总和
     * @return 钱币最少
     */
    public static int chargeDfs(int[] coins, int sum) {
        int count = dfs(coins, sum, 0, coins.length - 1);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    /**
     * 深度计算逻辑
     *
     * @param coins 硬币面值
     * @param sum   总和
     * @param count 数量
     * @param index 索引
     * @return 最小换值
     */
    private static int dfs(int[] coins, int sum, int count, int index) {
        if (sum == 0) {
            return count;
        } else if (sum > 0 && index >= 0) {
            int count1 = dfs(coins, sum, count, index - 1);
            int count2 = dfs(coins, sum - coins[index], count + 1, index);
            return Math.min(count1, count2);
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 换零钱最少 （深度树剪枝）
     *
     * @param coins 零钱数
     * @param sum   总和
     * @return 钱币最少
     */
    public static int chargeDfsDp(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, sum + 1);
        dp[0] = 0;
        dfs(coins, sum, coins.length - 1, dp);
        return dp[sum] > sum ? -1 : dp[sum];
    }

    /**
     * 深度计算逻辑
     *
     * @param coins 硬币面值
     * @param sum   总和
     * @param index 索引
     * @param dp    计算缓存
     */
    private static void dfs(int[] coins, int sum, int index, int[] dp) {
        if (sum > 0 && index >= 0 && coins[index] <= sum) {
            dfs(coins, sum, index - 1, dp);
            dfs(coins, sum - coins[index], index, dp);
            dp[sum] = Math.min(dp[sum], dp[sum - coins[index] + 1]);
        }
    }


    /**
     * 基于动态规划实现
     *
     * @param coins 币种
     * @param sum   总额
     * @return 最小币数
     */
    public static int chargeDp(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, sum + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = sum; j >= 1; j--) {
                for (int k = 1; k * coin <= j; k++) {
                    dp[j] = Math.min(dp[j], dp[j - k * coin] + k);
                }
            }
        }
        return dp[sum] > sum ? -1 : dp[sum];
    }

    /**
     * 换零钱 动态规划
     *
     * @param coins  硬币
     * @param amount 总值
     * @return 总数
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 总和大小遍历
        for (int i = 1; i <= amount; i++) {
            // 币值遍历
            for (int coin : coins) {
                // 如果币值小于总值
                if (coin <= i) {
                    // 则dp[i]值为剩余值加一之间小值
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 换零钱总数统计
     *
     * @param amount 总额
     * @param coins  币组
     * @return 换零钱总数统计
     */

    public static int change(int amount, int[] coins) {
        int[] result = {0};
        Set<String> pathSet = new HashSet<>();
        dfsCount(coins, pathSet, new LinkedList<>(), amount, result);
        return result[0];
    }

    /**
     * 深度计算逻辑
     *
     * @param coins  币组
     * @param amount 总额
     * @param result 结果
     */
    private static void dfsCount(int[] coins, Set<String> pathSet, Deque<Integer> path, int amount, int[] result) {
        if (amount == 0) {
            int[] subCoins = path.stream().mapToInt(i -> i).toArray();
            Arrays.sort(subCoins);
            String str = Arrays.toString(subCoins);
            boolean addFlag = pathSet.add(str);
            if (addFlag) {
                result[0]++;
            }
        } else if (amount > 0) {
            for (int coin : coins) {
                if (coin <= amount) {
                    path.offerLast(coin);
                    dfsCount(coins, pathSet, path, amount - coin, result);
                    path.pollLast();
                }
            }
        }
    }

    /**
     * 换零钱总数统计
     * 初始化 dp[0]=1
     * 遍历 coins，对于其中的每个元素 coin，进行如下操作：
     * 遍历 i从coin到amount将dp[i−coin]的值加到dp[i]
     * 最终得到dp[amount]的值即为答案。
     *
     * @param amount 总额
     * @param coins  币组
     * @return 换零钱总数统计
     */
    public static int changeL0(int amount, int[] coins) {
        // 动态规划
        int[] dp = new int[amount + 1];
        //dp[x] 表示金额之和等于 x 的硬币组合数，目标是求dp[amount]
        dp[0] = 1;// 等于0只有1种
        for (int coin : coins) {
            // 从coin开始累加计算即可
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    /**
     * 换零钱
     *
     * @param coins  零钱数组
     * @param target 目标钱
     * @return 换钱方案数
     */
    public static int chargeBt(int[] coins, int target) {
        int[] result = {0};
        dfsBt(coins, target, 0, result);
        return result[0];
    }

    private static void dfsBt(int[] coins, int target, int index, int[] result) {
        if (target == 0) {
            result[0]++;
        } else if (target > 0 && index < coins.length) {
            dfsBt(coins, target, index + 1, result);
            dfsBt(coins, target - coins[index], index, result);
        }
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int sum = 5;
        int count = change(sum, coins);
        System.out.println(count);
    }
}
