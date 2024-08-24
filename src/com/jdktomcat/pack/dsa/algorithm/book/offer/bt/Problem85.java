package com.jdktomcat.pack.dsa.algorithm.book.offer.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成匹配的括号
 */
public class Problem85 {

    /**
     * 处理函数
     *
     * @param left        左括号个数
     * @param right       右括号个数
     * @param parenthesis 字符串
     * @param result      结果
     */
    private static void helper(int left, int right, String parenthesis, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(parenthesis);
            return;
        }
        if (left > 0) {
            helper(left - 1, right, parenthesis + "(", result);
        }
        if (left < right) {
            helper(left, right - 1, parenthesis + ")", result);
        }
    }

    /**
     * 生成匹配括号
     *
     * @param n 目标
     * @return 列表
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, n, "", result);
        return result;
    }


    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        for (String re : result) {
            System.out.println(re);
        }
    }
}
