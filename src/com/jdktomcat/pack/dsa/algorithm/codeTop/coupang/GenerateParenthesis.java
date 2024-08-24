package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {

    /**
     * 生成有效括号对数
     *
     * @param num 数量
     * @return 所有组合
     */
    public static List<String> generateParenthesis(int num) {
        List<String> result = new ArrayList<>();
        dfs(num, num, "", result);
        return result;
    }

    /**
     * 深度遍历计算逻辑
     *
     * @param leftNum     左括号数量
     * @param rightNum    右括号数量
     * @param parenthesis 组合
     * @param result      结果
     */
    private static void dfs(int leftNum, int rightNum, String parenthesis, List<String> result) {
        if (leftNum == 0 && rightNum == 0) {
            result.add(parenthesis);
            return;
        }
        if (leftNum > 0) {
            dfs(leftNum - 1, rightNum, parenthesis + '(', result);
        }
        if (leftNum < rightNum) {
            dfs(leftNum, rightNum - 1, parenthesis + ')', result);
        }
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println(Arrays.toString(generateParenthesis(num).toArray()));
    }

}
