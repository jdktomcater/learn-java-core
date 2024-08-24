package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class SubSet {
    /**
     * 子集
     *
     * @param numbers 数组
     * @return 子集列表
     */
    public static List<List<Integer>> subsets(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(numbers, 0, new LinkedList<>(), result);
        return result;
    }

    /**
     * 深度遍历计算逻辑
     *
     * @param numbers 数组
     * @param index   索引
     * @param subs    子集
     * @param result  结果
     */
    private static void dfs(int[] numbers, int index, LinkedList<Integer> subs, List<List<Integer>> result) {
        if (index == numbers.length) {
            result.add(new ArrayList<>(subs));
        } else if (index < numbers.length) {
            dfs(numbers, index + 1, subs, result);
            subs.offerLast(numbers[index]);
            dfs(numbers, index + 1, subs, result);
            subs.pollLast();
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        List<List<Integer>> result = subsets(numbers);
        for (List<Integer> permute : result) {
            System.out.println(Arrays.toString(permute.toArray()));
        }
    }
}
