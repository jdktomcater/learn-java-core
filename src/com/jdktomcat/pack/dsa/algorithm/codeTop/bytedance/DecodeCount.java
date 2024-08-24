package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * 解码方法
 */
public class DecodeCount {

    /**
     * 解码方法(动态规划)
     *
     * @param target 目标字符串
     * @return 解码方法统计
     */
    public static int numDecodings(String target) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            set.add(i + "");
        }
        int[] dp = new int[target.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < target.length() + 1; i++) {
            if (set.contains(target.substring(i - 1, i))) {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && set.contains(target.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[target.length()];
    }

    /**
     * 解码方法
     *
     * @param target 目标字符串
     * @return 解码方法统计
     */
    public static int numDecodingsL1(String target) {
        int n = target.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (target.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && target.charAt(i - 2) != '0' && ((target.charAt(i - 2) - '0') * 10 + (target.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }



    /**
     * 解码方法
     *
     * @param target 目标字符串
     * @return 解码方法统计
     */
    public static int numDecodingsL0(String target) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            set.add(i + "");
        }
        int[] count = {0};
        dfs(target, set, 0, new StringBuilder(), count);
        return count[0];
    }

    /**
     * 深度计算逻辑
     *
     * @param target        目标字符串
     * @param set           字符集合
     * @param index         索引
     * @param stringBuilder 匹配
     * @param result        结果
     */
    private static void dfs(String target, Set<String> set, int index, StringBuilder stringBuilder, int[] result) {
        if (stringBuilder.length() == target.length()) {
            result[0]++;
        } else if (index < target.length() && stringBuilder.length() < target.length()) {
            if (set.contains(target.substring(index, index + 1))) {
                stringBuilder.append(target, index, index + 1);
                dfs(target, set, index + 1, stringBuilder, result);
                stringBuilder.delete(index, index + 1);
            }
            if (index < target.length() - 1 && set.contains(target.substring(index, index + 2))) {
                stringBuilder.append(target, index, index + 2);
                dfs(target, set, index + 2, stringBuilder, result);
                stringBuilder.delete(index, index + 2);
            }
        }
    }

    public static void main(String[] args) {
        String target = "0";
        System.out.println(numDecodings(target));
    }

}
