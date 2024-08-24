package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.tiktok;

/**
 * 最长无重复字符子串最大长度
 */
public class MaxNoRepeatSub {

    public static int lengthOfLongestSubstring(String target) {
        int left = 0, right = 0, max = 0;
        for (; right < target.length(); right++) {
            int prev = target.indexOf(target.charAt(right), left);
            if (prev != -1 && prev < right) {
                max = Math.max(max, right - left);
                left = prev + 1;
            }
        }
        return Math.max(max, right - left);
    }

    public static void main(String[] args) {
        String target = " ";
        System.out.println(lengthOfLongestSubstring(target));
    }

}
