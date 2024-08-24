package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 分割数组
 */
public class PartitionDisjoint {

    /**
     * 分割数组索引
     *
     * @param numbers 数组
     * @return 分割数组索引
     */
    public int partitionDisjoint(int[] numbers) {
        int[] maxLeft = new int[numbers.length];
        int[] minRight = new int[numbers.length];
        int max = numbers[0];
        for (int i = 0; i < numbers.length; ++i) {
            max = Math.max(max, numbers[i]);
            maxLeft[i] = max;
        }
        int min = numbers[numbers.length - 1];
        for (int i = numbers.length - 1; i >= 0; --i) {
            min = Math.min(min, numbers[i]);
            minRight[i] = min;
        }
        for (int i = 1; i < numbers.length; ++i) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        return -1;
    }
}
