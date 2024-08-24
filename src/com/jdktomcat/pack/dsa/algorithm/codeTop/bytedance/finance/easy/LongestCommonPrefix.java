package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

/**
 * 最长共同前缀
 */
public class LongestCommonPrefix {

    /**
     * 最长共同前缀
     *
     * @param strs 字符串数组
     * @return 最长共同前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        return commonPrefix(strs, 0, strs.length - 1);
    }

    /**
     * 最长共同前缀
     *
     * @param strs  字符串数组
     * @param left  左索引
     * @param right 右索引
     * @return 最长共同前缀
     */
    private static String commonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        if (left + 1 == right) {
            return commonPrefix(strs[left], strs[right]);
        }
        int mid = (right + left) >> 1;
        return commonPrefix(commonPrefix(strs, left, mid), commonPrefix(strs, mid + 1, right));
    }

    /**
     * 最长共同前缀
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最长共同前缀
     */
    private static String commonPrefix(String str1, String str2) {
        int index = 0, minL = Math.min(str1.length(), str2.length());
        while (index < minL && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));
    }
}
