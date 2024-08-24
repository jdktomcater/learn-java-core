package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p85;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 生成匹配的括号
 */
public class GenerateParentHesis {

    /**
     * 生成括号对
     *
     * @param n 对数
     * @return 所有括号对
     */
    public static List<String> generateParentHesis(int n) {
        List<String> result = new LinkedList<>();
        helper(n, n, "", result);
        return result;
    }

    /**
     * 循环处理体
     *
     * @param left   左括号索引
     * @param right  右括号索引
     * @param hesis  括号对
     * @param result 结果列表
     */
    private static void helper(int left, int right, String hesis, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(hesis);
            return;
        }
        if (left > 0) {
            helper(left - 1, right, hesis + "(", result);
        }
        if (left < right) {
            helper(left, right - 1, hesis + ")", result);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> result = generateParentHesis(n);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
