package com.jdktomcat.pack.dsa.algorithm.book.offer.string.p19;

/**
 * 最多删除一个字符得到回文
 */
public class ValidPalindrome {

    /**
     * 是否最多删除一个字符得到回文
     *
     * @param string 目标字符串
     * @return true：可以 false:不可以
     */
    public static boolean validPalindrome(String string) {
        int start = 0;
        int end = string.length() - 1;
        for (; start < string.length() / 2; ++start, --end) {
            if (string.charAt(start) != string.charAt(end)) {
                break;
            }
        }
        return start == string.length() / 2 || isPalindrome(string, start, end - 1) || isPalindrome(string, start + 1, end);
    }

    /**
     * 判断是否是回文
     *
     * @param string 目标字符串
     * @param start  开始索引
     * @param end    结束索引
     * @return true：是 false:否
     */
    public static boolean isPalindrome(String string, int start, int end) {
        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        return start >= end;
    }

}
