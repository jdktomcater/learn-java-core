package com.jdktomcat.pack.dsa.algorithm.leetcode.d20220417;

import java.util.Arrays;

/**
 * 类概述：
 *
 * @author tangqi
 * @date 2022-04-17
 */
public class Practise01 {
    /**
     * 计算
     *
     * @param nums 数组
     * @return 长度
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int remove = 0;
        int target = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == Integer.MAX_VALUE) {
                break;
            }
            if (nums[index] == target) {
                if (nums.length - 1 - index >= 0) {
                    System.arraycopy(nums, index + 1, nums, index, nums.length - 1 - index);
                }
                nums[nums.length - 1] = Integer.MAX_VALUE;
                index--;
                remove++;
            }else{
                target = nums[index];
            }
        }
        return nums.length - remove;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
