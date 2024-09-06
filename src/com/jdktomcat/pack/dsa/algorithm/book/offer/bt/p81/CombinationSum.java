package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p81;

import java.util.LinkedList;
import java.util.List;

/**
 * 允许重复选择元素的组合
 */
public class CombinationSum {

    /**
     * 元素之和等于目标值的组合
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 元素之和等于目标值的组合
     */
    public static List<List<Integer>> combinationSum(int[] numbers, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(numbers, target, 0, combination, result);
        return result;
    }

    /**
     * 处理逻辑
     *
     * @param numbers 目标数组
     * @param index   索引
     * @param subList 子集列表
     * @param result  所有子集列表
     */
    private static void helper(int[] numbers, int target, int index, LinkedList<Integer> subList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(subList));
        } else if (target > 0 && index < numbers.length) {
            // 一个元素不加入集合
            helper(numbers, target, index + 1, subList, result);
            // 一个元素加入集合
            subList.add(numbers[index]);
            helper(numbers, target - numbers[index], index, subList, result);
            // 去除修改
            subList.removeLast();
        }
    }
}
