package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.HashMap;
import java.util.Map;

/**
 * 异位词相关问题
 */
public class AnagramWordIssue {
    /**
     * 判断是否为异位词
     *
     * @param s 单词1
     * @param t 单词2
     * @return true：是 false：否
     */
    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        int i = 0, j = 0;
        while (i < s.length() || j < t.length()) {
            if (i < s.length()) {
                count[s.charAt(i++) - 'a']++;
            }
            if (j < t.length()) {
                count[t.charAt(j++) - 'a']--;
            }
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否为异位词
     *
     * @param s 单词1
     * @param t 单词2
     * @return true：是 false：否
     */
    public static boolean isAnagramL0(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        int i = 0, j = 0;
        while (i < s.length() || j < t.length()) {
            if (i < s.length()) {
                int value = countMap.getOrDefault(s.charAt(i), 0) + 1;
                if (value != 0) {
                    countMap.put(s.charAt(i), value);
                } else {
                    countMap.remove(s.charAt(i));
                }
                i++;
            }
            if (j < t.length()) {
                int value = countMap.getOrDefault(t.charAt(j), 0) - 1;
                if (value != 0) {
                    countMap.put(t.charAt(j), value);
                } else {
                    countMap.remove(t.charAt(j));
                }
                j++;
            }
        }
        return countMap.isEmpty();
    }

}
