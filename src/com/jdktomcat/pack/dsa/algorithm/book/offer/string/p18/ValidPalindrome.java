package com.jdktomcat.pack.dsa.algorithm.book.offer.string.p18;

/**
 * 有效的回文
 */
public class ValidPalindrome {

    /**
     * 判断是否是回文
     *
     * @param s 目标字符串
     * @return true：是 false:否
     */
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!Character.isLetterOrDigit(ch1)) {
                i++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                j--;
            } else {
                ch1 = Character.toLowerCase(ch1);
                ch2 = Character.toLowerCase(ch2);
                if (ch1 != ch2) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
