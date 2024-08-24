package com.jdktomcat.pack.dsa.algorithm.book.offer.num.p4;

/**
 * 只出现一次的数字
 */
public class OccurOnlyOnce {

    /**
     * 只出现一次的数字
     *
     * @param numbers 数组
     * @return 只出现一次的数字
     */
    public static int singleNumber(int[] numbers) {
        int[] bitSums = new int[32];
        for (int num : numbers) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (32 - i)) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }
        return result;
    }

}
