package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 无重复字符的最长子串
 */
public class NoRepeatCharLongestSubString {

    /**
     * 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度
     *
     * @param target 目标字符串
     * @return 无重复字符的最长子串
     */
    public static int lengthOfLongestSubstring(String target) {
        if (target.length() < 2) {
            return target.length();
        }
        int left = 0, max = 1;
        for (int right = 1; right < target.length(); right++) {
            char ch = target.charAt(right);
            int preIndex = target.indexOf(ch, left);
            if (preIndex < right && preIndex != -1) {
                max = Math.max(max, right - left);
                left = preIndex + 1;
            }
        }
        return Math.max(max, target.length() - left + 1);
    }
}
