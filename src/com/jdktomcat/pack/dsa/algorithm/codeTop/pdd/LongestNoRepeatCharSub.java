package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd;

/**
 * 无重复字符的最长子串
 */
public class LongestNoRepeatCharSub {

    /**
     * 无重复字符的最长子串长度
     *
     * @param target 目标字符串
     * @return 无重复字符的最长子串长度
     */
    public static int lengthOfLongestSubstring(String target) {
        if (target.length() < 2) {
            return target.length();
        }
        int left = 0, right = 0, max = 0;
        while (right < target.length()) {
            int bi = target.indexOf(target.charAt(right), left);
            if (bi != -1 && bi < right) {
                max = Math.max(right - left, max);
                left = bi + 1;
            }
            right++;
        }
        return Math.max(max, right - left);
    }

    public static void main(String[] args) {
        String target = "aab";
        System.out.println(lengthOfLongestSubstring(target));
    }

}
