package com.jdktomcat.pack.dsa.algorithm.company.xiaomi.easy;

/**
 * 回文数字判断
 */
public class PalindromeNumber {

    /**
     * 回文数字判断
     *
     * @param x 数字
     * @return 回文数字判断
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int number = 0;
        int temp = x;
        while (temp != 0) {
            number = number * 10 + temp % 10;
            temp = temp / 10;
        }
        return number == x;
    }

    public static void main(String[] args) {
        int num = -121;
        System.out.println(isPalindrome(num));
    }
}
