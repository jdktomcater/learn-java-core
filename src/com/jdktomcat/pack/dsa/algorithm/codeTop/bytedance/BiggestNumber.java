package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;

/**
 * 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 */
public class BiggestNumber {

    /**
     * 最大数
     *
     * @param numbers 数组
     * @return 最大数
     */
    public static String largestNumber(int[] numbers) {
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numArr = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numArr[i] = numbers[i];
        }
        Arrays.sort(numArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (sx * y + x - sy * x - y);
        });
        if (numArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(numbers));
    }
}
