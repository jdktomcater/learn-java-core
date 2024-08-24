package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.easy;


import java.util.Arrays;

/**
 * 左旋转字符串
 */
public class ReverseLeftWords {

    /**
     * 左旋转字符串
     *
     * @param s 目标字符串
     * @param n 数量
     * @return 左旋转字符串
     */
    public static String reverseLeftWords(String s, int n) {
        String target = s + s;
        char[] chars = target.toCharArray();
        return new String(Arrays.copyOfRange(chars, n, s.length() + n));
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        int n = 6;
        System.out.println(reverseLeftWords(s, n));
    }

}
