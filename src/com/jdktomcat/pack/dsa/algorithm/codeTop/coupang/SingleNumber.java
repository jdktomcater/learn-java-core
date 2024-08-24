package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 只出现一次的数字
 */
public class SingleNumber {

    /**
     * 只出现一次的数字
     *
     * @param numbers 数组
     * @return 只出现一次的数字
     */
    public static int singleNumber(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result ^= numbers[i];
        }
        return result;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] numbers = {2,2,1};
        System.out.println(singleNumber(numbers));
    }

}
