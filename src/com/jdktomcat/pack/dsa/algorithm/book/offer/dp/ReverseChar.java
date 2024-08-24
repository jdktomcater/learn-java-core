package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;


/**
 * 0001100110 翻转字符 转换成所有0在1前需要最少次数
 */
public class ReverseChar {

    /**
     * 翻转字符串
     *
     * @param target 目标字符串
     * @return 最小次数
     */
    public static int reverseChar(String target) {
        int length = target.length();
        if (length < 2) {
            return 0;
        }
        int[][] dp = new int[2][2];
        char ch = target.charAt(0);
        dp[0][0] = ch == '0' ? 0 : 1;
        dp[1][0] = ch == '1' ? 0 : 1;
        for (int index = 1; index < length; index++) {
            ch = target.charAt(index);
            int prev0 = dp[0][(index - 1) % 2];
            int prev1 = dp[1][(index - 1) % 2];
            dp[0][index % 2] = prev0 + (ch == '0' ? 0 : 1);
            dp[1][index % 2] = Math.min(prev0, prev1) + (ch == '1' ? 0 : 1);
        }
        return Math.min(dp[0][(length - 1) % 2], dp[1][(length - 1) % 2]);
    }

    public static void main(String[] args) {
        String target = "10000";
        System.out.println(reverseChar(target));
    }


}
