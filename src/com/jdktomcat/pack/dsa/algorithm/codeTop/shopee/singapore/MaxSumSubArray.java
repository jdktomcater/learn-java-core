package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

import java.util.Arrays;

public class MaxSumSubArray {

    public static int maxSubArray(int[] nums) {
        int[] result = {Integer.MIN_VALUE};
        dfs(nums, 0, 0, nums[0], result);
        return result[0];
    }

    private static void dfs(int[] nums, int left, int right, int sum, int[] result) {
        if (left <= right && right < nums.length) {
            result[0] = Math.max(result[0], sum);
            if (right < nums.length - 1) {
                dfs(nums, left, right + 1, sum + nums[right + 1], result);
            }
            dfs(nums, left + 1, right, sum - nums[left], result);
        }
    }

    public static int maxSubArray1(int[] nums) {
        return dfs1(nums, 0, 0, nums[0]);
    }

    private static int dfs1(int[] nums, int left, int right, int sum) {
        int max = Integer.MIN_VALUE;
        if (left <= right && right < nums.length) {
            max = sum;
            if (right < nums.length - 1) {
                int up = dfs1(nums, left, right + 1, sum + nums[right + 1]);
                max = Math.max(max, up);
            }
            int down = dfs1(nums, left + 1, right, sum - nums[left]);
            max = Math.max(max, down);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs2(nums, dp, 0, 0, nums[0]);
    }

    private static int dfs2(int[] nums, int[][] dp, int left, int right, int sum) {
        int max = Integer.MIN_VALUE;
        if (left <= right && right < nums.length) {
            dp[left][right] = sum;
            max = dp[left][right];
            if (right < nums.length - 1) {
                if (dp[left][right + 1] == Integer.MIN_VALUE) {
                    dp[left][right + 1] = dfs2(nums, dp, left, right + 1, sum + nums[right + 1]);
                }
                max = Math.max(max, dp[left][right + 1]);
            }
            if (dp[left + 1][right] == Integer.MIN_VALUE) {
                dp[left + 1][right] = dfs2(nums, dp, left + 1, right, sum - nums[left]);
            }
            max = Math.max(max, dp[left + 1][right]);
        }
        return max;
    }

    public static int maxSubArray3(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            } else {
                int sum = nums[i];
                for (int j = i - 1; j >= 0; j--) {
                    sum += nums[j];
                }
                dp[i] = Math.max(dp[i - 1], sum);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int maxSubArray4(int[] nums) {
        int[] dp = new int[nums.length];
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
            max = Math.max(max, sum);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, dp[i] - dp[j]);
            }
        }
        return max;
    }

    public static int maxSubArray5(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int number : nums) {
            pre = Math.max(pre + number, number);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray5(nums));
    }
}
