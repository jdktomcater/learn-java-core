package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    /**
     * 无重复字符的最长子串
     *
     * @param s 目标字符串
     * @return 无重复字符的最长子串
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        for (; right < s.length(); right++) {
            char ch = s.charAt(right);
            int preIndex = s.indexOf(ch, left);
            if (preIndex != -1 && preIndex < right) {
                max = Math.max(max, right - left);
                left = preIndex + 1;
            }
        }
        return Math.max(max, right - left);
    }
}
