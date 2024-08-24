package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p94;

/**
 * 最少回文分割
 */
public class MinimumPalindromeSegmentation {

    /**
     * 最少分割数
     *
     * @param s 目标字符串
     * @return 最少分割数
     */
    public static int minCut(String s) {
        // 长度
        int length = s.length();
        // 是否是回文
        boolean[][] isPal = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                // 判断是否是回文
                if (ch1 == ch2 && (i <= j + 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                }
            }
        }
        // 缓存f(i)结果信息
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 1; j <= i; j++) {
                    // 如果是回文的话，j-1 加1
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        String s = "aaba23234dsfx";
        System.out.println(minCut(s));
    }
}
