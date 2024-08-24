package com.jdktomcat.pack.dsa.algorithm.book.offer.string.p14;

/**
 * 字符串中个的变位词
 */
public class AnamorphicWords {

    /**
     * 判断是否包含
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return true:包含 false:不包含
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        if (areAllZero(counts)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if (areAllZero(counts)) {
                return true;
            }
        }
        return false;
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
        String s1 = "ab";
        String s2 = "dgcaf";
        System.out.println(checkInclusion(s1, s2));
    }

}
