package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstringNoRepeat {

    /**
     * 无重复字符的最长子串
     *
     * @param source 目标字符串
     * @return 最长长度
     */
    public static int lengthOfLongestSubstring(String source) {
        int max = 0, left = 0, right = 0;
        while (right < source.length()) {
            char ch = source.charAt(right);
            int pre = source.indexOf(ch, left);
            if (pre < right) {
                max = Math.max(max, right - left);
                left = pre + 1;
            }
            right++;
        }
        return Math.max(max, right - left);
    }

}
