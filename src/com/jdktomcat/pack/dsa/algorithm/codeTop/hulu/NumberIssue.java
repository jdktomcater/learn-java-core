package com.jdktomcat.pack.dsa.algorithm.codeTop.hulu;

/**
 * 数字相关问题
 */
public class NumberIssue {

    /**
     * 数字反转
     *
     * @param x 原始数字
     * @return 反转后数字
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    /**
     * 是否是回文数
     *
     * @param x 目标数字
     * @return true：是 false：否
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rx = reverse(x);
        return rx == x;
    }

}
