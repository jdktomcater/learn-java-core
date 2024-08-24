package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p79;

import java.util.ArrayList;
import java.util.Arrays;
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
        LinkedList<Integer> subList = new LinkedList<>();
        helper(numbers, 0, subList, result);
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
            result.add(new LinkedList<>(subList));
        } else if (index < numbers.length) {
            // 一个元素不加入集合
            helper(numbers, index + 1, subList, result);
            // 一个元素加入集合
            subList.add(numbers[index]);
            helper(numbers, index + 1, subList, result);
            // 去除修改
            subList.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 20};
        List<List<Integer>> result = subSet(numbers);
        for (List<Integer> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}
