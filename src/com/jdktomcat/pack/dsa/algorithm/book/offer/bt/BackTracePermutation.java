package com.jdktomcat.pack.dsa.algorithm.book.offer.bt;

import com.jdktomcat.pack.dsa.algorithm.book.offer.util.SwapUtil;

import java.util.*;

public class BackTracePermutation {

    /**
     * 处理
     *
     * @param nums   目标数组
     * @param i      索引
     * @param result 结果
     */
    private static void helper(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            LinkedList<Integer> permutation = new LinkedList<>();
            for (int num : nums) {
                permutation.addLast(num);
            }
            result.add(permutation);
        } else {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (set.contains(j)) {
                    continue;
                }
                set.add(j);
                SwapUtil.swap(nums, i, j);
                helper(nums, i + 1, result);
                SwapUtil.swap(nums, i, j);
            }
        }
    }


    /**
     * 排列
     *
     * @param nums 目标数组
     * @return 排列结果
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums, 0, result);
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
