package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 阶乘后的零
 */
public class TrailingZeroes {

    /**
     * 阶乘后的零个数
     *
     * @param n 目标
     * @return 个数
     */
    public static int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }

    /**
     * 阶乘后的零个数
     *
     * @param n 目标
     * @return 个数
     */
    public static int trailingZeroesL0(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
