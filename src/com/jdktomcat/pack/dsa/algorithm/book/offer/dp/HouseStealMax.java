package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;

/**
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 单序列动态规划
 */
public class HouseStealMax {

    /**
     * 偷盗计算
     *
     * @param wealth 房屋财物数组
     * @return 最大获益
     */
    public static int steal(int[] wealth) {
        int length = wealth.length;
        int[] dp = new int[2];
        dp[0] = wealth[0];
        dp[1] = Math.max(wealth[0], wealth[1]);
        for (int index = 2; index < length; index++) {
            dp[index % 2] = Math.max(dp[(index - 2) % 2] + wealth[index], dp[(index - 1) % 2]);
        }
        return Math.max(dp[0], dp[1]);
    }

    /**
     * 偷盗计算
     *
     * @param wealth 房屋财物数组
     * @param start  开始
     * @param end    结束
     * @return 最大获益
     */
    public static int stealRange(int[] wealth, int start, int end) {
        int[] dp = new int[2];
        dp[0] = wealth[start];
        dp[1] = Math.max(wealth[start], wealth[start + 1]);
        for (int index = start + 2; index <= end; index++) {
            int len = index - start;
            dp[len % 2] = Math.max(dp[(len - 2) % 2] + wealth[index], dp[(len - 1) % 2]);
        }
        return Math.max(dp[0], dp[1]);
    }

    /**
     * 环装屋
     *
     * @param wealth 数组
     * @return 最大
     */
    public static int loopSteal(int[] wealth) {
        if (wealth.length == 0) {
            return 0;
        }
        if (wealth.length == 1) {
            return wealth[0];
        }
        return Math.max(stealRange(wealth, 0, wealth.length - 2), stealRange(wealth, 1, wealth.length - 1));
    }

    public static void main(String[] args) {
        int[] wealth = new int[]{2, 7, 9, 3, 1};
        System.out.println(steal(wealth));
        System.out.println(loopSteal(wealth));
    }

}
