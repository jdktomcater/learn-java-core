package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd;

import java.util.HashMap;
import java.util.Map;

/**
 * 和可被 K 整除的子数组
 */
public class SubArraysDivByK {

    /**
     * 给定一个整数数组 nums 和一个整数 k 返回其中元素之和可被k整除的（连续、非空）子数组的数目。
     * 子数组 是数组的 连续 部分。
     *
     * @param nums 数组
     * @param k    目标值
     * @return 子数组数量
     */
    public static int subarraysDivByK(int[] nums, int k) {
        int left = 0, right = 0, sum = nums[0];
        int[] count = {0};
        dfs(nums, k, left, right, sum, count);
        return count[0];
    }

    /**
     * 深度计算逻辑
     *
     * @param nums  数组
     * @param k     除数
     * @param left  左索引
     * @param right 右索引
     * @param sum   和
     * @param count 结果
     */
    private static void dfs(int[] nums, int k, int left, int right, int sum, int[] count) {
        if (sum % k == 0) {
            count[0]++;
        }
        if (left > right) {
            return;
        }
        if (right < nums.length - 1) {
            dfs(nums, k, left, right + 1, sum + nums[right + 1], count);
        }
        if (left < nums.length - 1) {
            dfs(nums, k, left + 1, right, sum - nums[left], count);
        }
    }

    /**
     * 给定一个整数数组 nums 和一个整数 k 返回其中元素之和可被k整除的（连续、非空）子数组的数目。
     * 子数组 是数组的 连续 部分。
     *
     * @param nums 数组
     * @param k    目标值
     * @return 子数组数量
     */
    public static int subarraysDivByKL0(int[] nums, int k) {
        int count = 0;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
                if (dp[i][j] % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 哈希表 + 逐一统计
     *
     * @param nums 数组
     * @param k 除数
     * @return
     */
    public static int subarraysDivByKL1(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    public int subarraysDivByKL2(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;
            record.put(modulus, record.getOrDefault(modulus, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            ans += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByKL0(nums, k));
    }

}
