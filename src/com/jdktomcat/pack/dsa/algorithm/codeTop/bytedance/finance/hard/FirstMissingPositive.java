package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.hard;

/**
 * 缺失的第一个正数
 */
public class FirstMissingPositive {

    /**
     * 缺失的第一个正数
     *
     * @param numbers 数组
     * @return 缺失的第一个正数
     */
    public static int firstMissingPositive(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            // 交换
            while (numbers[i] > 0 && numbers[i] <= numbers.length && numbers[numbers[i] - 1] != numbers[i]) {
                swap(numbers, numbers[i] - 1, i);
            }
        }
        // 查找第一个不相等数字
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != i + 1) {
                return i + 1;
            }
        }
        // 返回最大
        return numbers.length + 1;
    }

    /**
     * 数据交互
     *
     * @param numbers 数组
     * @param index1  索引1
     * @param index2  索引2
     */
    private static void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}
