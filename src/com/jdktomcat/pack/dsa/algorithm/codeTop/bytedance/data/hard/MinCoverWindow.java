package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.hard;

/**
 * 最小覆盖子串
 */
public class MinCoverWindow {

    /**
     * 最小覆盖子字符串
     *
     * @param s 原字符串
     * @param t 目标字符串
     * @return 最小字符串
     */
    public static String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int[] hash = new int[128];
        for (char ch : chart) {
            hash[ch]--;
        }
        String res = "";
        for (int right = 0, left = 0, cnt = 0; right < chars.length; right++) {
            // 统计计数
            hash[chars[right]]++;
            // 判断字符出现次数
            if (hash[chars[right]] <= 0) {
                cnt++;
            }
            // 窗口左边界向右移动
            while (cnt == chart.length && hash[chars[left]] > 0) {
                hash[chars[left++]]--;
            }
            // 判断其值是否是窗口大小
            if (cnt == chart.length) {
                // 交换条件
                if (res.equals("") || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String source = "aa";
        String target = "aa";
        System.out.println(minWindow(source, target));
    }
}
