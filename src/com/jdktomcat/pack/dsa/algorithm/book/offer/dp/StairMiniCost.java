package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;


/**
 * 爬楼梯的最⼩代价（花费成本）
 * 给定⼀个数组cost，其中cost[i]的值就代表着你爬第[i]阶的台阶的开销。⼀旦你付了这个开销，你就可以继续往上爬⼀阶或者两阶，知道你
 * 达到最顶层（数组的结尾元素再多⼀层）。同时你可以选择从第0阶开始或者第⼀阶开始。
 * 我们的⽬标是找出你爬到最顶层所付出的最⼩的开销。
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: 最低开销是，从第1阶（15）开始，只花费15就可以到顶层。
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: 最低开销是，从第0阶开始（1），然后只⾛值为1的台阶，其中跳过第3阶。
 * <p>
 * 算法分析：
 * <p>
 * f(i)：
 * 1、i=0 return cost[0]
 * 2、i=1 return cost[1]
 * 3、i>1 return min(f(n-2,f(n-1))) + cost[i]
 */
public class StairMiniCost {

    /**
     * 计算
     *
     * @param cost  原始数组
     * @param stair 台阶
     * @return 最小消耗
     */
    private static int recursionHelp(int[] cost, int stair) {
        if (stair < 2) {
            return cost[stair];
        }
        return Math.min(recursionHelp(cost, stair - 2), recursionHelp(cost, stair - 1)) + cost[stair];
    }

    /**
     * 递归计算
     *
     * @param cost 参数
     * @return 最小
     */
    public static int recursion(int[] cost) {
        int length = cost.length;
        return Math.min(recursionHelp(cost, length - 2), recursionHelp(cost, length - 1));
    }

    /**
     * 计算
     *
     * @param cost  原始数组
     * @param stair 台阶
     * @return 最小消耗
     */
    private static void recursionCacheHelp(int[] cost, int stair, int[] dp) {
        if (stair < 2) {
            dp[stair] = cost[stair];
        } else if (dp[stair] == 0) {
            recursionCacheHelp(cost, stair - 2, dp);
            recursionCacheHelp(cost, stair - 1, dp);
            dp[stair] = Math.min(dp[stair - 2], dp[stair - 1]) + cost[stair];
        }
    }

    /**
     * 递归计算
     *
     * @param cost 参数
     * @return 最小
     */
    public static int recursionCache(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        recursionCacheHelp(cost, length - 1, dp);
        return Math.min(dp[length - 2], dp[length - 1]);
    }

    /**
     * 自下而上循环缓存数组计算
     * time：O(n)
     * space: O(n)
     *
     * @param cost 目标数组
     * @return 最小值
     */
    public static int loopCache(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int index = 2; index < length; index++) {
            dp[index] = Math.min(dp[index - 2], dp[index - 1]) + cost[index];
        }
        return Math.min(dp[length - 2], dp[length - 1]);
    }

    /**
     * 自下而上循环缓存数组计算
     * time：O(n)
     * space: O(1)
     *
     * @param cost 目标数组
     * @return 最小值
     */
    public static int loopCacheAdvance(int[] cost) {
        int length = cost.length;
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int index = 2; index < length; index++) {
            dp[index % 2] = Math.min(dp[0], dp[1]) + cost[index];
        }
        return Math.min(dp[0], dp[1]);
    }


    public static void main(String[] args) {
        int[] cost = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(recursion(cost));
        System.out.println(recursionCache(cost));
        System.out.println(loopCache(cost));
        System.out.println(loopCacheAdvance(cost));
    }
}
