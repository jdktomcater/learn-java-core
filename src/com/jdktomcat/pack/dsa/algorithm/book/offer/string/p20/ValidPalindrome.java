package com.jdktomcat.pack.dsa.algorithm.book.offer.string.p20;

/**
 * 回文子字符串的个数
 */
public class ValidPalindrome {

    /**
     * 统计回文子字符串的个数
     *
     * @param string 目标字符串
     * @return 个数
     */
    public static int countSubStrings(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            count += countPalindrome(string, i, i);
            count += countPalindrome(string, i, i + 1);
        }
        return count;
    }

    /**
     * 统计回文个数
     *
     * @param string 目标字符串
     * @param start  开始索引
     * @param end    截止索引
     * @return 回文个数
     */
    private static int countPalindrome(String string, int start, int end) {
        int count = 0;
        while (start >= 0 && end < string.length() && string.charAt(start) == string.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

}
