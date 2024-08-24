package com.jdktomcat.pack.dsa.algorithm.book.offer.string.p16;

/**
 * 不包含重复字符的最长子字符串
 */
public class NoContainRepeatCharSubString {

    /**
     * 不包含重复字符的最长子字符串长度
     *
     * @param string 目标字符串
     * @return 不包含重复字符的最长子字符串长度
     */
    public static int lengthOfLongestSubString(String string) {
        if (string.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        int longest = 1;
        for (; i < string.length(); i++) {
            counts[string.charAt(i)]++;
            while (hasGreaterThan1(counts)) {
                ++j;
                counts[string.charAt(j)]--;
            }
            longest = Math.max(i - j, longest);
        }
        return longest;
    }

    /**
     * 判断是否有大于1的数组元素
     *
     * @param counts 数组
     * @return true：有 false：无
     */
    private static boolean hasGreaterThan1(int[] counts) {
        for (int num : counts) {
            if (num > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String target1 = "abcabcbb";
        System.out.println(lengthOfLongestSubString(target1));
    }
}
