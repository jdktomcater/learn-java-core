package com.jdktomcat.pack.dsa.algorithm.book.offer.num.p3;

/**
 * 前n个数字二进制形式中1的个数
 */
public class BinaryOneCount {
    /**
     * 前n个数字二进制形式中1的个数
     *
     * @param num 数字
     * @return 前n个数字二进制形式中1的个数
     */
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }

    /**
     * 前n个数字二进制形式中1的个数
     *
     * @param num 数字
     * @return 前n个数字二进制形式中1的个数
     */
    public static int[] countBitsL0(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

}
