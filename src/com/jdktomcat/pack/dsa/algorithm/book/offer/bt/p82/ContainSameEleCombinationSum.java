package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p82;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 包含重复元素集合的组合
 */
public class ContainSameEleCombinationSum {

    /**
     * 元素和等于目标值target组合
     *
     * @param numbers 目标数组
     * @param target  target
     * @return 元素组合
     */
    public static List<List<Integer>> combinationSum(int[] numbers, int target) {
        Arrays.sort(numbers);
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
            helper(numbers, target, getNext(numbers, index), subList, result);
            // 一个元素加入集合
            subList.add(numbers[index]);
            helper(numbers, target - numbers[index], index + 1, subList, result);
            // 去除修改
            subList.removeLast();
        }
    }

    /**
     * 获取下一个一样的值
     *
     * @param numbers 数组
     * @param index   索引
     * @return 值
     */
    private static int getNext(int[] numbers, int index) {
        int next = index;
        while (next < numbers.length && numbers[next] == numbers[index]) {
            next++;
        }
        return next;
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{2, 2, 2, 4, 3, 3};
        int target = 8;
        List<List<Integer>> result = combinationSum(numbers, target);
        for (List<Integer> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}
