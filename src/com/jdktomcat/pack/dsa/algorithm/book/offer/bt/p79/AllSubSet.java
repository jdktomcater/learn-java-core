package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p79;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 所有子集
 */
public class AllSubSet {

    /**
     * 所有子集
     *
     * @param numbers 目标数组
     * @return 子集列表
     */
    public static List<List<Integer>> subSet(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        helper(numbers, 0, new LinkedList<>(), result);
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
    private static void helper(int[] numbers, int index, LinkedList<Integer> subList, List<List<Integer>> result) {
        if (index == numbers.length) {
            // 目标结果
            result.add(new LinkedList<>(subList));
        } else if (index < numbers.length) {
            // 一个元素不加入集合
            helper(numbers, index + 1, subList, result);
            // 一个元素加入集合
            subList.add(numbers[index]);
            // 下次计算
            helper(numbers, index + 1, subList, result);
            // 去除修改
            subList.removeLast();
        }
    }
}
