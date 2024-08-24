package com.jdktomcat.pack.dsa.algorithm.codeTop.ks;

/**
 * 不同的二叉搜索树
 */
public class NumberOfTree {
    /**
     * 不同的二叉搜索树(动态规划)
     *
     * @param n 数字
     * @return 不同的二叉搜索树个数
     */
    public static int numTreesL0(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 不同的二叉搜索树(递归)
     *
     * @param n 数字
     * @return 不同的二叉搜索树个数
     */
    public static int numTreesL1(int n) {
        return getRes(0, n);
    }

    /**
     * 深度计算逻辑
     *
     * @param left  左数字
     * @param right 右数字
     * @return 个数
     */
    public static int getRes(int left, int right) {
        // 截止条件
        if (left == right || right - left == 1) {
            return 1;
        }
        int numOfTree = 0;
        for (int i = left; i < right; i++) {
            numOfTree += getRes(left, i) * getRes(i + 1, right);
        }
        return numOfTree;
    }
}
