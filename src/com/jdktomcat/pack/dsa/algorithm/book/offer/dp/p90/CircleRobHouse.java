package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p90;

/**
 * 环形房屋偷盗
 */
public class CircleRobHouse {

    /**
     * 计算逻辑
     *
     * @param numbers 房屋信息
     * @return 最大
     */
    public static int rob(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int result1 = helper(numbers, 0, numbers.length - 2);
        int result2 = helper(numbers, 1, numbers.length - 1);
        return Math.max(result1, result2);
    }

    /**
     * 计算逻辑
     *
     * @param numbers 房屋信息
     * @param start   开始
     * @param end     结束
     * @return 最大
     */
    private static int helper(int[] numbers, int start, int end) {
        int[] dp = new int[2];
        dp[0] = numbers[start];
        if (start < end) {
            dp[1] = Math.max(numbers[start], numbers[start + 1]);
        }
        for (int i = start + 2; i <= end; i++) {
            int j = i - start;
            dp[j % 2] = Math.max(dp[(j - 1) % 2], dp[(j - 2) % 2] + numbers[i]);
        }
        return dp[(end - start) % 2];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 4, 5, 3};
        System.out.println("环形最大抢劫财产数：" + rob(numbers));
    }
}
