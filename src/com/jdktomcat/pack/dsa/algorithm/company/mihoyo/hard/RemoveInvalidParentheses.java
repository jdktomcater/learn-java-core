package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除无效括号
 */
public class RemoveInvalidParentheses {

    /**
     * 最少删除无效括号(深度计算逻辑)
     *
     * @param s 目标字符串
     * @return 移除后结果
     */
    public static List<String> removeInvalidParentheses(String s) {
        int lr = 0, rr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lr++;
            } else if (s.charAt(i) == ')') {
                if (lr == 0) {
                    rr++;
                } else {
                    lr--;
                }
            }
        }
        List<String> res = new ArrayList<>();
        dfs(s, 0, lr, rr, res);
        return res;
    }

    /**
     * 深度计算逻辑
     *
     * @param str   字符串
     * @param start 开始索引
     * @param lr    需要左括号删出个数
     * @param rr    需要右括号删出个数
     * @param res   结果
     */
    private static void dfs(String str, int start, int lr, int rr, List<String> res) {
        // 判断深度计算逻辑终止条件
        if (lr == 0 && rr == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lr + rr > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            String str1 = str.substring(0, i) + str.substring(i + 1);
            if (lr > 0 && str.charAt(i) == '(') {
                dfs(str1, i, lr - 1, rr, res);
            }
            // 尝试去掉一个右括号
            if (rr > 0 && str.charAt(i) == ')') {
                dfs(str1, i, lr, rr - 1, res);
            }
        }
    }

    private static boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    /**
     * 最少删除无效括号(广度度计算逻辑)
     *
     * @param s 目标字符串
     * @return 移除后结果
     */
    public static List<String> removeInvalidParenthesesL0(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> currSet = new HashSet<>();
        currSet.add(s);
        while (true) {
            for (String str : currSet) {
                if (isValid(str)) {
                    ans.add(str);
                }
            }
            if (ans.size() > 0) {
                return ans;
            }
            Set<String> nextSet = new HashSet<>();
            for (String str : currSet) {
                for (int i = 0; i < str.length(); i++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }
    }
}
