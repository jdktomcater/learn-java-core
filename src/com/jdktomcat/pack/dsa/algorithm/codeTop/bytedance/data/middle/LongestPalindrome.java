package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

/**
 * 最长回文字符串
 */
public class LongestPalindrome {
    /**
     * 最长回文子串
     *
     * @param target 目标字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String target) {
        int[] max = {Integer.MIN_VALUE, 0, 0};
        for (int i = 0; i < target.length(); i++) {
            int[] maxOdd = palindromeLength(target, i, i);
            if (max[0] < maxOdd[0]) {
                max = maxOdd;
            }
            int[] maxEven = palindromeLength(target, i, i + 1);
            if (max[0] < maxEven[0]) {
                max = maxEven;
            }
        }
        return target.substring(max[1], max[2]);
    }

    /**
     * 回文长度
     *
     * @param target 目标字符串
     * @param left   左起点
     * @param right  右起点
     * @return 回文长度
     */
    private int[] palindromeLength(String target, int left, int right) {
        int len = 0, leftIndex = left, rightIndex = right;
        while (leftIndex >= 0 && rightIndex < target.length() && target.charAt(leftIndex) == target.charAt(rightIndex)) {
            len += (leftIndex == rightIndex ? 1 : 2);
            leftIndex--;
            rightIndex++;
        }
        // 偶奇数
        return left != right ? new int[]{len, left - len / 2 + 1, right + len / 2} : new int[]{len, left - len / 2, right + len / 2 + 1};
    }
}
