package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 最长递增子序列
 */
public class LongestIncreaseSubSequence {

    /**
     * 最长递增子序列长度
     *
     * @param numbers 数组
     * @return 最长递增子序列长度
     */
    public static int lengthOfLIS(int[] numbers) {
        // 判断长度
        if (numbers.length == 0) {
            return 0;
        }
        // 动态缓存
        int[] dp = new int[numbers.length];
        dp[0] = 1;
        int max = 1;
        // 遍历
        for (int i = 1; i < numbers.length; i++) {
            // 设置初始值为1
            dp[i] = 1;
            // 再遍历之前的元素
            for (int j = 0; j < i; j++) {
                // 如果判断索引节点大于前节点
                if (numbers[i] > numbers[j]) {
                    // 需要判断dp[j]+1与现在的大小，取大者
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 再取大者
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 10, 4, 3, 8, 9};
        System.out.println(lengthOfLIS(numbers));
    }

}
