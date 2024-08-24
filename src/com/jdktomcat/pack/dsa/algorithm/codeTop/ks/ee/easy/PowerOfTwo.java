package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.easy;

/**
 * 2的幂
 */
public class PowerOfTwo {

    /**
     * 最大数
     */
    static final int BIG = 1 << 30;

    /**
     * 判断是否是2的幂
     *
     * @param n 目标数字
     * @return true：是 false：否
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && BIG % n == 0;
    }
}
