package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p32;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的变位词
 */
public class ValidAnamorphicWords {

    /**
     * 判断是否是变位词
     *
     * @param str1 字符1
     * @param str2 字符2
     * @return true：是 false：否
     */
    public static boolean isAnagramArray(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char ch : str1.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (char ch : str2.toCharArray()) {
            if (counts[ch - 'a'] == 0) {
                return false;
            }
            counts[ch - 'a']--;
        }
        return true;
    }

    /**
     * 判断是否是变位词
     *
     * @param str1 字符1
     * @param str2 字符2
     * @return true：是 false：否
     */
    public static boolean isAnagramHash(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            if (countMap.getOrDefault(ch, 0) == 0) {
                return false;
            }
            countMap.put(ch, countMap.get(ch) - 1);
        }
        return true;
    }
}
