package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p93;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长斐波那契子序列长度
 */
public class LongestFibonacciSubSequence {

    /**
     * 计算最长斐波那契子序列长度
     *
     * @param numbers 数组
     * @return 最长长度
     */
    public static int countLongestFibonacciSubSequence(int[] numbers) {
        // 便于查找
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        // 动态缓存
        int[][] dp = new int[numbers.length][numbers.length];
        // 最终结果
        int result = 2;
        // 双层遍历
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                // 判断是否存在目标差值
                int k = map.getOrDefault(numbers[i] - numbers[j], -1);
                // 动态缓存逻辑：差值存在且小于前值，前计算缓存+1，否则为初始2
                dp[i][j] = k >= 0 && k < j ? dp[j][k] + 1 : 2;
                // 取较大值返回
                result = Math.max(result, dp[i][j]);
            }
        }
        return result > 2 ? result : 0;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(countLongestFibonacciSubSequence(numbers));
    }
}
