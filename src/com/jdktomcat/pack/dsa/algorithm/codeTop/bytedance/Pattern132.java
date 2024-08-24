package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 132 模式
 * <p>
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 */
public class Pattern132 {

    /**
     * 132模式匹配(暴力)
     *
     * @param numbers 数组
     * @return true:匹配成功 false：匹配失败
     */
    public static boolean find132patternL0(int[] numbers) {
        if (numbers.length < 3) {
            return false;
        }
        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[j] > numbers[k] && numbers[k] > numbers[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 132模式匹配(查找最大值3)
     *
     * @param numbers 数组
     * @return true:匹配成功 false：匹配失败
     */
    public static boolean find132patternL1(int[] numbers) {
        if (numbers.length < 3) {
            return false;
        }
        // 左侧最小值
        int leftMin = numbers[0];
        // 右侧所有元素(出现的次数)
        TreeMap<Integer, Integer> rightAll = new TreeMap<>();
        // 遍历从第三处开始
        for (int k = 2; k < numbers.length; ++k) {
            rightAll.put(numbers[k], rightAll.getOrDefault(numbers[k], 0) + 1);
        }
        // 从第二处开始遍历
        for (int j = 1; j < numbers.length - 1; ++j) {
            // 判断是否大于最小值
            if (leftMin < numbers[j]) {
                // 最小值
                Integer next = rightAll.ceilingKey(leftMin + 1);
                // 判断目标值条件
                if (next != null && next < numbers[j]) {
                    return true;
                }
            }
            // 处理最小值
            leftMin = Math.min(leftMin, numbers[j]);
            // 向右移，处理元素
            rightAll.put(numbers[j + 1], rightAll.get(numbers[j + 1]) - 1);
            // 如果元素个数为0，则删除
            if (rightAll.get(numbers[j + 1]) == 0) {
                rightAll.remove(numbers[j + 1]);
            }
        }
        return false;
    }

    /**
     * 132模式匹配(查找最大值1 单调栈)
     *
     * @param numbers 数组
     * @return true:匹配成功 false：匹配失败
     */
    public static boolean find132patternL2(int[] numbers) {
        // 单调栈（存储j值，单调递减栈）
        Deque<Integer> candidateK = new LinkedList<>();
        // 反向处理
        candidateK.push(numbers[numbers.length - 1]);
        // k最大值
        int maxK = Integer.MIN_VALUE;
        for (int i = numbers.length - 2; i >= 0; --i) {
            // 目标条件
            if (numbers[i] < maxK) {
                return true;
            }
            // 处理单调栈
            while (!candidateK.isEmpty() && numbers[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            // 如果大于k最大值，则加入栈
            if (numbers[i] > maxK) {
                candidateK.push(numbers[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 0, 1, -4, -3};
        System.out.println(find132patternL2(numbers));
    }

}
