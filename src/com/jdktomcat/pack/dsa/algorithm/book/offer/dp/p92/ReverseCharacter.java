package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p92;

/**
 * 字符反转
 */
public class ReverseCharacter {

    /**
     * 字符反转最小次数
     *
     * @param s 目标字符串
     * @return 最小次数
     */
    public static int minFlipsMono(String s) {
        // 字符串长度
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        // 动态规划缓存：最后变成变成0 最后变成1所需要的次数 两次
        int[][] dp = new int[2][2];
        // 首字符初始化
        char ch = s.charAt(0);
        dp[0][0] = ch == '0' ? 0 : 1;
        dp[1][0] = ch == '1' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            ch = s.charAt(i);
            // 上一次结尾转为0所需要的最少次数
            int prev0 = dp[0][(i - 1) % 2];
            // 上一次结尾转为1所需要的最少次数
            int prev1 = dp[1][(i - 1) % 2];
            // 这一次转化为0的计算逻辑：这次如果是1的需要反转，否则不需要
            dp[0][i % 2] = prev0 + (ch == '0' ? 0 : 1);
            // 这一次转化为1的计算逻辑：两者最小，如果是1的话不需要反转，非1则反转
            dp[1][i % 2] = Math.min(prev0, prev1) + (ch == '1' ? 0 : 1);
        }
        // 取最小即可
        return Math.min(dp[0][(len - 1) % 2], dp[1][(len - 1) % 2]);
    }

    public static void main(String[] args) {
        String target = "00110";
        System.out.println(minFlipsMono(target));
    }

}
