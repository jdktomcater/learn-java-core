package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;


/**
 * 字符串编织
 */
public class StringInterLeave {


    /**
     * 字符串3是否可以使用1和2编织而成
     *
     * @param target1 字符串1
     * @param target2 字符串2
     * @param target3 字符串3
     * @return true：可以 false：不可以
     */
    public static boolean isInterleave(String target1, String target2, String target3) {
        if (target1.length() + target2.length() != target3.length()) {
            return false;
        }
        if (target1.length() < target2.length()) {
            return isInterleave(target2, target1, target3);
        }
        boolean[] dp = new boolean[target2.length() + 1];
        dp[0] = true;
        for (int j = 0; j < target2.length(); j++) {
            dp[j + 1] = (target2.charAt(j) == target3.charAt(j) && dp[j]);
        }
        for (int i = 0; i < target1.length(); i++) {
            dp[0] = dp[0] && target1.charAt(i) == target3.charAt(i);
            for (int j = 0; j < target2.length(); j++) {
                char ch1 = target1.charAt(i);
                char ch2 = target2.charAt(j);
                char ch3 = target3.charAt(i + j + 1);
                dp[j + 1] = (ch1 == ch3 && dp[j + 1]) || (ch2 == ch3 && dp[j]);
            }
        }
        return dp[target2.length()];
    }

    public static void main(String[] args) {
        String target1 = "aabcc";
        String target2 = "dbbca";
        String target3 = "aadbbcbcac";
        System.out.println(isInterleave(target1, target2, target3));
    }

}
