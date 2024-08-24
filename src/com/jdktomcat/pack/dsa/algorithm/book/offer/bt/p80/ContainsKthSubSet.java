package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p80;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 包含k个元素的组合
 */
public class ContainsKthSubSet {

    /**
     * 包含k个元素的组合
     *
     * @param n 元素个数
     * @param k 目标值
     * @return 包含k个元素的组合
     */
    public static List<List<Integer>> containsKthSubSet(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> subList = new LinkedList<>();
        helper(n, k, 1, subList, result);
        return result;
    }

    /**
     * 处理逻辑
     *
     * @param length  数组长度
     * @param index   索引
     * @param subList 子集列表
     * @param result  所有子集列表
     */
    private static void helper(int length, int size, int index, LinkedList<Integer> subList, List<List<Integer>> result) {
        if (subList.size() == size) {
            result.add(new LinkedList<>(subList));
        } else if (index <= length) {
            // 一个元素不加入集合
            helper(length, size, index + 1, subList, result);
            // 一个元素加入集合
            subList.add(index);
            helper(length, size, index + 1, subList, result);
            // 去除修改
            subList.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = containsKthSubSet(3, 2);
        for (List<Integer> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}
