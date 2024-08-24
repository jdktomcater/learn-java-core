package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 * 编辑距离相关问题
 */
public class EditDistanceIssue {

    /**
     * 给定两个字符串 source 和 target ，如果它们的编辑距离为 1 ，则返回 true ，否则返回 false 。
     *
     * @param source 起始字符串
     * @param target 目标字符串
     * @return 如果它们的编辑距离为 1 ，则返回 true ，否则返回 false 。
     */
    public static boolean isOneEditDistance(String source, String target) {
        if (Math.abs(source.length() - target.length()) > 1) {
            return false;
        }
        if (source.length() == target.length()) {
            boolean flag = false;
            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i) != target.charAt(i)) {
                    if (!flag) {
                        flag = true;
                    } else {
                        return false;
                    }
                }
            }
            return flag;
        }
        String longStr = source.length() > target.length() ? source : target;
        String shortStr = source.length() > target.length() ? target : source;
        boolean flag = true;
        int li = 0, si = 0;
        while (li < longStr.length() && si < shortStr.length() && (flag || longStr.charAt(li) == shortStr.charAt(si))) {
            if (longStr.charAt(li) != shortStr.charAt(si)) {
                flag = false;
                li++;
            } else {
                li++;
                si++;
            }
        }
        return li == longStr.length() || si == shortStr.length();
    }

    /**
     * 字符串编辑最小距离
     *
     * @param source 起始字符串
     * @param target 目标字符串
     * @return 字符串编辑最小距离
     */
    public static int minDistance(String source, String target) {
        // 缓存从字符source从0到i位字符串转换成target从0到j位字符串编辑最小距离
        int[][] dp = new int[source.length() + 1][target.length() + 1];
        for (int i = 0; i < target.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < source.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < source.length(); i++) {
            for (int j = 0; j < target.length(); j++) {
                if (source.charAt(i) == target.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // 状态转移方程取三种状态下最小值加1，其中dp[i][j + 1]相当于新增操作 dp[i + 1][j]删除操作  dp[i][j]相当于更新操作
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                }
            }
        }
        return dp[source.length()][target.length()];
    }


    public static void main(String[] args) {
        String source = "horse";
        String target = "ros";
        System.out.println(minDistance(source, target));
    }
}
