package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 最大子数组和
 */
public class BiggestSumSubArray {

    /**
     * 最大子序列和(动态规划)
     * f(0) = n(0)
     * f(i) = max(f(i-1)+n(i),n(i))
     *
     * @param numbers 数组
     * @return 最大子序列和
     */
    public static int maxSubArray(int[] numbers) {
        int pre = 0, max = numbers[0];
        for (int number : numbers) {
            pre = Math.max(pre + number, number);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {-2, 1};
        System.out.println(maxSubArray(numbers));
    }
}
