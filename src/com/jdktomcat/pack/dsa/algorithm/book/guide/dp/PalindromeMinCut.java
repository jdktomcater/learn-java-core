package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

/**
 * 回文最少切次数
 */
public class PalindromeMinCut {

    public static int minCut(String target) {
        if (target == null || target.equals("")) {
            return 0;
        }
        char[] chars = target.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[chars.length] = -1;
        boolean[][] pal = new boolean[chars.length][chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            dp[i] = chars.length + 1;
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j] && (j - i < 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String target = "AD";
        System.out.println(minCut(target));
    }
}
