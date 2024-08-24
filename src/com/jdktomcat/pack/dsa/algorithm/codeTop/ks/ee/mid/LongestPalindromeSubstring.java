package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

/**
 * 最长回文子串
 */
public class LongestPalindromeSubstring {

    /**
     * 最长回文子串
     *
     * @param source 源字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String source) {
        int max = 0;
        String longestPalindrome = "";
        for (int i = 0; i < source.length(); i++) {
            int[] odd = palindrome(source, i, i);
            if (odd[0] > max) {
                max = odd[0];
                longestPalindrome = source.substring(odd[1], odd[2]);
            }
            int[] even = palindrome(source, i, i + 1);
            if (even[0] > max) {
                max = even[0];
                longestPalindrome = source.substring(even[1], even[2]);
            }
        }
        return longestPalindrome;
    }

    /**
     * 回文逻辑计算
     *
     * @param source 源字符串
     * @param left   左索引
     * @param right  右索引
     * @return 长度、左边界、右边界
     */
    private static int[] palindrome(String source, int left, int right) {
        boolean isOdd = left == right;
        int length = 0, li = left, ri = right;
        while (li >= 0 && ri < source.length() && source.charAt(li) == source.charAt(ri)) {
            if (li == ri) {
                length++;
            } else {
                length += 2;
            }
            li--;
            ri++;
        }
        if (isOdd) {
            return new int[]{length, left - length / 2, right + length / 2 + 1};
        }
        return new int[]{length, left - length / 2 + 1, right + length / 2};
    }

    public static void main(String[] args) {
        String target = "babad";
        System.out.println(longestPalindrome(target));
    }
}
