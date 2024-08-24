package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 */
public class CombinationSum {

    /**
     * 组合总和
     *
     * @param candidates 数组
     * @param target     目标
     * @return 组合列表
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, result, 0, target, new LinkedList<>());
        return result;
    }

    /**
     * 深度遍历逻辑
     *
     * @param candidates  数组
     * @param result      结果
     * @param sum         和
     * @param combination 组合列表
     */
    private static void dfs(int[] candidates, List<List<Integer>> result, int index, int sum, LinkedList<Integer> combination) {
        if (index < candidates.length) {
            if (sum == 0) {
                result.add(new ArrayList<>(combination));
            } else if (sum > 0) {
                dfs(candidates, result, index + 1, sum, combination);
                combination.addLast(candidates[index]);
                dfs(candidates, result, index, sum - candidates[index], combination);
                combination.removeLast();
            }
        }
    }

    /**
     * 组合总和
     *
     * @param candidates 数组
     * @param target     目标
     * @return 组合列表
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs2(candidates, result, 0, target, new LinkedList<>());
        return result;
    }

    /**
     * 深度遍历逻辑
     *
     * @param candidates  数组
     * @param result      结果
     * @param sum         和
     * @param combination 组合列表
     */
    private static void dfs2(int[] candidates, List<List<Integer>> result, int index, int sum, LinkedList<Integer> combination) {
        if (sum == 0) {
            result.add(new ArrayList<>(combination));
        } else if (sum > 0 && index < candidates.length) {
            dfs2(candidates, result, nextIndex(candidates, index), sum, combination);
            combination.offerLast(candidates[index]);
            dfs2(candidates, result, index + 1, sum - candidates[index], combination);
            combination.pollLast();
        }
    }

    /**
     * 下一个索引
     *
     * @param candidates 数组
     * @param index      索引
     * @return 下一个索引
     */
    private static int nextIndex(int[] candidates, int index) {
        while (index < candidates.length - 1 && candidates[index] == candidates[index + 1]) {
            index++;
        }
        return index + 1;
    }

    /**
     * 组合列表
     *
     * @param candidates 数组
     * @return 组合列表
     */
    public static List<List<Integer>> combination(int[] candidates) {
        List<List<Integer>> result = new ArrayList<>();
        dfsAll(candidates, result, 0, new LinkedList<>());
        return result;
    }

    /**
     * 深度计算逻辑
     *
     * @param candidates  数组
     * @param result      结果
     * @param index       索引
     * @param combination 组合
     */
    private static void dfsAll(int[] candidates, List<List<Integer>> result, int index, LinkedList<Integer> combination) {
        if (index >= candidates.length) {
            result.add(new ArrayList<>(combination));
        } else {
            dfsAll(candidates, result, index + 1, combination);
            combination.addLast(candidates[index]);
            dfsAll(candidates, result, index + 1, combination);
            combination.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> result = combinationSum2(numbers, target);
        for (List<Integer> combination : result) {
            System.out.println(Arrays.toString(combination.toArray()));
        }
    }
}
