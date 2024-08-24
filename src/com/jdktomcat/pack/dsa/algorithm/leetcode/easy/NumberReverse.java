package com.jdktomcat.pack.dsa.algorithm.leetcode.easy;

/**
 * 类描述：数字反转
 *
 * @author 汤旗
 * @date 2019-11-06 16:04
 */
public class NumberReverse {

    public static int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        String numStr = x + "";
        if (x < 0) {
            numStr = numStr.substring(1);
        }
        for (int index = 0; index < numStr.length(); index++) {
            stringBuilder.append(numStr.charAt(numStr.length() - 1 - index));
        }
        return x < 0 ? -1 * Integer.parseInt(stringBuilder.toString()) : Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

}
