package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 生成有效括号
 */
public class GenerateParenthesis {

    /**
     * 生成有效括号组合
     *
     * @param n 括号对数
     * @return 有效括号组合
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, n, "");
        return result;
    }

    /**
     * 递归生成
     *
     * @param result      结果列表
     * @param left        左括号数目
     * @param right       右括号数目
     * @param parenthesis 括号信息
     */
    private static void dfs(List<String> result, int left, int right, String parenthesis) {
        if (left == 0 && right == 0) {
            result.add(parenthesis);
            return;
        }
        if (left > 0) {
            dfs(result, left - 1, right, parenthesis + "(");
        }
        if (left < right) {
            dfs(result, left, right - 1, parenthesis + ")");
        }
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(4);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
