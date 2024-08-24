package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence {

    /**
     * 最长公共子序列长度
     *
     * @param text1 字符1
     * @param text2 字符2
     * @return 最长公共子序列长度
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    /**
     * 最长重复子数组 (动态规划)
     * <p>
     * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
     *
     * @param numbers1 数组1
     * @param numbers2 数组2
     * @return 最长重复子数组
     */
    public static int findLength(int[] numbers1, int[] numbers2) {
        int max = 0;
        int[][] dp = new int[numbers1.length + 1][numbers2.length + 1];
        // 反向计算
        for (int i = numbers1.length - 1; i >= 0; i--) {
            for (int j = numbers2.length - 1; j >= 0; j--) {
                if (numbers1[i] == numbers2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static int findLengthL0(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    public static int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] numbers1 = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, numbers2 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(findLength(numbers1, numbers2));
    }

}
