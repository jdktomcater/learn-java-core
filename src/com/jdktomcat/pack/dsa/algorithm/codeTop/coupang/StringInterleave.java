package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 交错字符串
 * <p>
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 */
public class StringInterleave {

    /**
     * 交错字符串 （动态规划）
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @param s3 字符串3
     * @return true：可以 false：不可以
     */
    public static boolean isInterleaveL1(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        // 长度判断
        if (n + m != t) {
            return false;
        }
        // 缓存可编制状态(长度为n、m能否编织m+n长度字符串状态)
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                // 状态转移方程
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[n][m];
    }

    /**
     * 交错字符串 （动态规划）
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @param s3 字符串3
     * @return true：可以 false：不可以
     */
    public static boolean isInterleaveL0(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[m];
    }


    /**
     * 交错字符串
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @param s3 字符串3
     * @return true：可以 false：不可以
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        boolean[] result = {false};
        dfs(s1, s2, s3, 0, 0, 0, result);
        return result[0];
    }

    /**
     * 深度遍历计算逻辑
     *
     * @param s1     字符串1
     * @param s2     字符串2
     * @param s3     字符串3
     * @param i1     索引1
     * @param i2     索引2
     * @param i3     索引3
     * @param result 结果
     */
    private static void dfs(String s1, String s2, String s3, int i1, int i2, int i3, boolean[] result) {
        if (result[0]) {
            return;
        }
        if (i3 == s3.length()) {
            result[0] = true;
            return;
        }
        if (i3 < s3.length()) {
            if (i1 < s1.length()) {
                for (int i = i1; i < s1.length(); i++) {
                    if (s3.charAt(i3) == s1.charAt(i)) {
                        dfs(s1, s2, s3, i + 1, i2, i3 + 1, result);
                    }
                }
            }
            if (i2 < s2.length()) {
                for (int i = i2; i < s2.length(); i++) {
                    if (s3.charAt(i3) == s2.charAt(i)) {
                        dfs(s1, s2, s3, i1, i + 1, i3 + 1, result);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("a", "b", "a"));
    }

}
