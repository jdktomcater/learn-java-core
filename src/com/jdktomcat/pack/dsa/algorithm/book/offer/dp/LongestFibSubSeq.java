package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;


import com.jdktomcat.pack.util.jdk8.HashMap;

import java.util.Map;

/**
 * 最长斐波那契子数列
 */
public class LongestFibSubSeq {

    /**
     * 计算最长斐波那契子数列
     *
     * @param target 目标数组
     * @return 最长长度
     */
    public static int cal(int[] target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < target.length; index++) {
            map.put(target[index], index);
        }
        int result = 2;
        int[][] dp = new int[target.length][target.length];
        for (int i = 1; i < target.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = map.getOrDefault(target[i] - target[j], -1);
                dp[i][j] = k >= 0 && k < j ? dp[j][k] + 1 : 2;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result > 2 ? result : 0;
    }

    public static void main(String[] args) {
        int[] target = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(cal(target));
    }
}
