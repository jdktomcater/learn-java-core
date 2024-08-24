package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd.mock;

public class Mock20220815 {

    public static int maximumProduct(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = nums[0] * nums[1] * nums[2];
        return dp[nums.length];
    }

    public static boolean checkPossibility(int[] nums) {
        boolean[] res = new boolean[nums.length];
        res[0] = true;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] && nums[i - 1] <= nums[i] && flag;
            if (flag) {
                flag = nums[i - 1] <= nums[i];
            }
        }
        return res[nums.length - 1];
    }

    public static String longestPalindrome(String s) {
        return "";
    }

    public static void main(String[] args) {
        int[] nums = {4,2,3};
        System.out.println(checkPossibility(nums));

    }

}
