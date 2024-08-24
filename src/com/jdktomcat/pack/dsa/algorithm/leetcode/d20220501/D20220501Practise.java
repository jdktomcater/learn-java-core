package com.jdktomcat.pack.dsa.algorithm.leetcode.d20220501;

/**
 * 类概述：
 *
 * @author tangqi
 * @date 2022-05-02
 */
public class D20220501Practise {

    private static int steal(int[] nums, int index) {
        if (index < nums.length) {
            return nums[index] + Math.max(steal(nums, index + 2), steal(nums, index + 3));
        } else {
            return 0;
        }
    }
    public static int maxSteal(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(steal(nums, 0), steal(nums, 1));
    }
}
