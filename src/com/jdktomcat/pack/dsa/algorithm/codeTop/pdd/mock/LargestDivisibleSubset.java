package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最大整除子集
 */
public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int maxSize = 1, maxVal = nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] > maxSize) {
                    maxSize = dp[i];
                    maxVal = nums[i];
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        List<Integer> res = largestDivisibleSubset(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
