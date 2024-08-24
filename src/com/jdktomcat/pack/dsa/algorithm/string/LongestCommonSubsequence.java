package com.jdktomcat.pack.dsa.algorithm.string;

/**
 * 类描述：最大共同子序列长度
 *
 * @author 汤旗
 * @date 2019-10-11 20:44
 */
public class LongestCommonSubsequence {
    private volatile int age;

    /**
     * 最大共同子序列长度
     *
     * @param target1 目标字符序列1
     * @param target2 目标字符序列2
     * @param x       字符序列1索引
     * @param y       字符序列2索引
     * @return 最大共同序列长度
     */
    private static int lcs(String target1, String target2, int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        } else if (target1.charAt(x) == target2.charAt(y)) {
            return 1 + lcs(target1, target2, x - 1, y - 1);
        } else {
            return Math.max(lcs(target1, target2, x - 1, y), lcs(target1, target2, x, y - 1));
        }
    }

    public static void main(String[] args) {
        String target1 = "asdfghjlkw";
        String target2 = "lkwqewqeqwewq";
        System.out.println(lcs(target1, target2, target1.length() - 1, target2.length() - 1));
    }

}
