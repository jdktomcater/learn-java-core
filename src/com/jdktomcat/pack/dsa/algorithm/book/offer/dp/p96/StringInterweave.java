package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p96;

/**
 * 字符串交织
 */
public class StringInterweave {

    /**
     * 判断字符串s3是否可以用s1与s2编织成
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @param s3 字符串3
     * @return true：是 false：否
     */
    public static boolean isInterweave(String s1, String s2, String s3) {
        // 判断长度
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        // 长度小于的话，肯定不能
        if (len1 + len2 < len3) {
            return false;
        }
        // 动态缓存
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        // 默认起始值设置
        dp[0][0] = true;
        for (int i = 0; i < len1; i++) {
            dp[i + 1][0] = (s1.charAt(i) == s3.charAt(i) && dp[i][0]);
        }
        for (int j = 0; j < len2; j++) {
            dp[0][j + 1] = (s2.charAt(j) == s3.charAt(j) && dp[0][j]);
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);
                dp[i + 1][j + 1] = (ch1 == ch3 && dp[i][j + 1]) || (ch2 == ch3 && dp[i + 1][j]);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterweave(s1, s2, s3));
    }
}
