package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 第 N 位数字
 */
public class NthNumber {

    /**
     * 第 N 位数字（二分查找）
     *
     * 1位数字总长度  （10-1）*1
     * 2位数字总长度  （100-10）*2
     * 3位数字总长度  （1000-100）*2
     * 所以
     * n位数字总长度  （10的n次方减10的n-1次方）*n
     * @param nth 目标
     * @return 数字
     */
    public static int findNthDigit(int nth) {
        // 高低位
        int low = 1, high = 9;
        // 二分法寻找第nth数字所处数字位数
        while (low < high) {
            int mid = (high + low) / 2;
            // 数位总长度
            if (totalDigits(mid) < nth) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // 前一位数位总长度
        int prevDigits = totalDigits(low - 1);
        // 索引
        int index = nth - prevDigits - 1;
        // 开始数字
        int start = (int) Math.pow(10, low - 1);
        int num = start + index / low;
        int digitIndex = index % low;
        return (num / (int) (Math.pow(10, low - digitIndex - 1))) % 10;
    }

    /**
     * 计算位数数字位总和
     *
     * @param length 长度
     * @return 数字
     */
    public static int totalDigits(int length) {
        int digits = 0;
        int curLength = 1, curCount = 9;
        while (curLength <= length) {
            digits += curLength * curCount;
            curLength++;
            curCount *= 10;
        }
        return digits;
    }

    /**
     * 第 N 位数字 直接计算
     *
     * @param n 目标
     * @return 数字
     */
    public static int findNthDigitL0(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        return (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
    }
    public static void main(String[] args) {
        int n = 11;
        System.out.println(findNthDigitL0(n));
    }
}
