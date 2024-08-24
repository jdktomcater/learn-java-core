package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 丢失的数字
 */
public class MissingNumber {

    /**
     * 丢失的数字
     *
     * @param numbers 数组
     * @return 丢失的数字
     */
    public static int missingNumber(int[] numbers) {
        int sum = (numbers.length * (numbers.length + 1)) >> 1;
        for (int num : numbers) {
            sum -= num;
        }
        return sum;
    }
}
