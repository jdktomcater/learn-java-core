package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合相关问题
 */
public class CombinationIssue {

    /**
     * 组合列表
     *
     * @param candidates 目标数组
     * @param target     目标和
     * @return 组合列表
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 深度计算逻辑
     *
     * @param candidates  目标数组
     * @param target      目标值
     * @param index       索引
     * @param combination 组合列表
     * @param result      结果
     */
    private static void dfs(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
        } else if (target > 0 && index < candidates.length) {
            dfs(candidates, target, index + 1, combination, result);
            combination.add(candidates[index]);
            dfs(candidates, target - candidates[index], index, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(Arrays.toString(combination.toArray()));
        }
    }
}
