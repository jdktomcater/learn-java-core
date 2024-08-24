package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.hard;

/**
 * 最小覆盖字符串
 */
public class MinCoverString {

    /**
     * 最小覆盖字符串
     *
     * @param s 源字符串
     * @param t 目标字符串
     * @return 子字符串
     */
    public static String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int[] hash = new int[128];
        for (char ch : chart) {
            hash[ch]--;
        }
        String res = "";
        for (int right = 0, left = 0, cnt = 0; right < chars.length; right++) {
            hash[chars[right]]++;
            if (hash[chars[right]] <= 0) {
                cnt++;
            }
            while (cnt == chart.length && hash[chars[left]] > 0) {
                hash[chars[left++]]--;
            }
            if (cnt == chart.length) {
                if (res.equals("") || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
            }
        }
        return res;
    }
}
