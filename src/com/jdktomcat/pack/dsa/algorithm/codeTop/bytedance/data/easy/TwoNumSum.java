package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数和
 */
public class TwoNumSum {

    /**
     * 两数和
     *
     * @param nums   数组
     * @param target 目标和
     * @return 索引
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexData = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexData.containsKey(target - nums[i])) {
                return new int[]{indexData.get(target - nums[i]), i};
            }
            indexData.put(nums[i], i);
        }
        return new int[]{};
    }
}
