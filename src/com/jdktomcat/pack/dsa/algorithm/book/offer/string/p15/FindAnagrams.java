package com.jdktomcat.pack.dsa.algorithm.book.offer.string.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 查找变位词
 */
public class FindAnagrams {

    /**
     * 查找变位词下标列表
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 下标列表
     */
    public static List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> indices = new ArrayList<>();
        if (s1.length() < s2.length()) {
            return indices;
        }
        int[] counts = new int[26];
        int i = 0;
        for (; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']++;
            counts[s1.charAt(i) - 'a']--;
        }
        if (areAllZero(counts)) {
            indices.add(0);
        }
        for (; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']--;
            counts[s1.charAt(i - s2.length()) - 'a']++;
            if (areAllZero(counts)) {
                indices.add(i - s2.length() + 1);
            }
        }
        return indices;
    }

    /**
     * 判断是否全部是0
     *
     * @param counts 数组
     * @return true：是 false：否
     */
    private static boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "cbadabacg";
        String s2 = "abc";
        System.out.println(Arrays.toString(findAnagrams(s1, s2).toArray()));

    }


}
