package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.*;

/**
 * 全排列
 */
public class FullPermutation {

    /**
     * 全排列
     *
     * @param numbers 目标数组
     * @return 排列列表
     */
    public static List<List<Integer>> permute(int[] numbers) {
        // 结果
        List<List<Integer>> result = new ArrayList<>();
        // 回溯深度遍历
        dfs(numbers, 0, result);
        // 返回结果
        return result;
    }

    /**
     * 回溯深度遍历
     *
     * @param numbers 目标数组
     * @param index   索引
     * @param result  结果
     */
    private static void dfs(int[] numbers, int index, List<List<Integer>> result) {
        if (index == numbers.length) {
            List<Integer> permute = new ArrayList<>(numbers.length);
            for (int num : numbers) {
                permute.add(num);
            }
            result.add(permute);
        } else {
            for (int i = index; i < numbers.length; i++) {
                swap(numbers, index, i);
                dfs(numbers, index + 1, result);
                swap(numbers, index, i);
            }
        }
    }

    /**
     * 交换数组元素
     *
     * @param numbers 数组
     * @param i       元素下标1
     * @param j       元素下标2
     */
    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    /**
     * 全排列（包含重复）
     *
     * @param numbers 数组
     * @return 全排列（包含重复）
     */
    public static List<List<Integer>> permuteUnique(int[] numbers) {
        // 结果
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(numbers);
        // 回溯深度遍历
        dfsUnique(numbers, 0, result);
        // 返回结果
        return result;
    }

    /**
     * 回溯深度遍历（去重）
     *
     * @param numbers 目标数组
     * @param index   索引
     * @param result  结果
     */
    private static void dfsUnique(int[] numbers, int index, List<List<Integer>> result) {
        if (index == numbers.length) {
            List<Integer> permute = new ArrayList<>(numbers.length);
            for (int num : numbers) {
                permute.add(num);
            }
            result.add(permute);
        } else {
            Set<Integer> set = new HashSet<>();
            for (int i = index; i < numbers.length; i++) {
                if (!set.contains(numbers[i])) {
                    set.add(numbers[i]);
                    swap(numbers, index, i);
                    dfsUnique(numbers, index + 1, result);
                    swap(numbers, index, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(numbers);
        for (List<Integer> permute : result) {
            System.out.println(Arrays.toString(permute.toArray()));
        }
    }

}
