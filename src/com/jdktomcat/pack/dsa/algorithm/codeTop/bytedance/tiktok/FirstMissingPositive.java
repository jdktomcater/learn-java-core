package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.tiktok;

/**
 * 缺失的第一个正数
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] > 0 && numbers[i] <= numbers.length && numbers[numbers[i] - 1] != numbers[i]) {
                swap(numbers, numbers[i] - 1, i);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != i + 1) {
                return i + 1;
            }
        }
        return numbers.length + 1;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
