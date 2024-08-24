package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p89;

import java.util.Arrays;

/**
 * 房屋偷盗
 * <p>
 * f(i) = max(f(i-2) + nums[i],f(i-1)) i>=2
 * = max(nums[0],nums[1]) i = 1
 * = nums[0] i=0
 */
public class RobHouse {

    /**
     * 计算最大财产
     *
     * @param numbers 房屋财产
     * @return 最大财产
     */
    public static int rob(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int[] dp = new int[numbers.length];
        Arrays.fill(dp, -1);
        helper(numbers, numbers.length - 1, dp);
        return dp[dp.length - 1];
    }

    /**
     * 计算逻辑
     *
     * @param numbers 房屋财产
     * @param i       索引
     * @param dp      缓存
     */
    private static void helper(int[] numbers, int i, int[] dp) {
        if (i == 0) {
            dp[i] = numbers[0];
        } else if (i == 1) {
            dp[i] = Math.max(numbers[0], numbers[1]);
        } else if (dp[i] < 0) {
            helper(numbers, i - 2, dp);
            helper(numbers, i - 1, dp);
            dp[i] = Math.max(dp[i - 2] + numbers[i], dp[i - 1]);
        }
    }

    /**
     * 计算最大财产
     *
     * @param numbers 房屋财产
     * @return 最大财产
     */
    public static int robL2(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int[] dp = new int[numbers.length];
        dp[0] = numbers[0];
        if (numbers.length > 1) {
            dp[1] = Math.max(numbers[0], numbers[1]);
        }
        for (int i = 2; i < numbers.length; i++) {
            dp[i] = Math.max(dp[i - 2] + numbers[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    /**
     * 计算最大财产
     *
     * @param numbers 房屋财产
     * @return 最大财产
     */
    public static int robL3(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = numbers[0];
        if (numbers.length > 1) {
            dp[1] = Math.max(numbers[0], numbers[1]);
        }
        for (int i = 2; i < numbers.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 2) % 2] + numbers[i], dp[(i - 1) % 2]);
        }
        return dp[(numbers.length - 1) % 2];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 4, 5, 3};
        System.out.println("L1最大抢劫财产数：" + rob(numbers));
        System.out.println("L2最大抢劫财产数：" + robL2(numbers));
        System.out.println("L3最大抢劫财产数：" + robL3(numbers));
    }
}
