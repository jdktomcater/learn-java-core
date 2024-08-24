package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class SubSet {

    /**
     * 子集
     *
     * @param nums 数组
     * @return 子集列表
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(int[] nums, int index, List<Integer> subSet, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subSet));
        } else if (index < nums.length) {
            dfs(nums, index + 1, subSet, result);
            subSet.add(nums[index]);
            dfs(nums, index + 1, subSet, result);
            subSet.remove(subSet.size() - 1);
        }
    }
}
