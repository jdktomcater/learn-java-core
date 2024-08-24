package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

/**
 * 查找N位数字
 */
public class FindNthDigit {

    /**
     * 查找位数字
     *
     * @param n 目标数字
     * @return 查找位数字
     */
    public static int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1, start = (int) Math.pow(10, d - 1), num = start + index / d, digitIndex = index % d;
        return (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
    }

    /**
     * 计算数字所在的位数
     *
     * @param number 目标数字
     * @return 位数
     */
    private static int[] getByte(int number) {
        int[] count = {0, 9};
        for (int i = 1; i <= 9; i++) {
            count[0] += (int) (9 * Math.pow(10, i - 1));
            if (count[0] >= number) {
                count[0] = number - count[0];
                count[1] = i;
                return count;
            }
        }
        return count;
    }

    /**
     * 获取长度前所有数字个数
     *
     * @param length 长度
     * @return 个数
     */
    private static int getTotalCount(int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            count += (int) (9 * Math.pow(10, i));
        }
        return count;
    }
}
