package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.mock;

import java.util.*;

public class BiggestSet {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new TreeSet<>(), result);
        return result;
    }

    public static void dfs(int[] nums, int index, TreeSet<Integer> set, List<Integer> result) {
        if (index == nums.length) {
            if (set.size() > result.size()) {
                result.clear();
                result.addAll(set);
            }
        } else if (index < nums.length) {
            int max = set.size() == 0 ? 0 : set.last();
            boolean flag = max % nums[index] == 0 || nums[index] % max == 0;
            if (flag) {
                set.add(nums[index]);
                dfs(nums, index + 1, set, result);
                set.remove(nums[index]);
                dfs(nums, index + 1, set, result);
            } else {
                dfs(nums, index + 1, set, result);
            }
        }
    }

    public static List<Integer> largestDivisibleSubsetL0(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 题目中说「没有重复元素」很重要
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }
        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};
        System.out.println(Arrays.toString(largestDivisibleSubset(nums).toArray()));
        List<Integer> list = new ArrayList<>();
        boolean flag = list.stream().allMatch(i -> i % 2 == 0 || 2 % i == 0);
        System.out.println(flag);
    }
}
