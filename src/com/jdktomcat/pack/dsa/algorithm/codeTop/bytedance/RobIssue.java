package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 打家劫舍 相关问题（动态规划）
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class RobIssue {

    /**
     * 打家劫舍 相关问题（动态规划）
     *
     * @param numbers 房屋信息
     * @return 最大金额
     */
    public static int rob(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int[] dp = new int[numbers.length + 1];
        dp[0] = 0;
        dp[1] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + numbers[i], dp[i]);
        }
        return dp[numbers.length];
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3, 1};
        System.out.println(rob(numbers1));
        int[] numbers2 = {2,7,9,3,1};
        System.out.println(rob(numbers2));
    }

}
