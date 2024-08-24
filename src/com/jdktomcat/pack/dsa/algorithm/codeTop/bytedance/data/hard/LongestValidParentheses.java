package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 */
public class LongestValidParentheses {

    /**
     * 最长有效括号（双向遍历）
     *
     * @param target 目标字符串
     * @return 最长有效括号长度
     */
    public static int longestValidParenthesesL0(String target) {
        // 左、右括号数目 最大有效括号数目
        int left = 0, right = 0, max = 0;
        // 正序遍历
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            // 左右括号数量相等，则计算长度
            if (left == right) {
                max = Math.max(max, 2 * right);
                // 如果右括号数量大于左括号数量，则重置
            } else if (right > left) {
                left = right = 0;
            }
        }
        // 反向遍历，重置
        left = right = 0;
        for (int i = target.length() - 1; i >= 0; i--) {
            if (target.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            // 左右括号数量相等，则计算长度
            if (left == right) {
                max = Math.max(max, 2 * left);
                // 如果左括号数量大于右括号数量，则重置
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }

    /**
     * 最长有效括号（单向栈）
     *
     * @param target 目标字符串
     * @return 最长有效括号长度
     */
    public static int longestValidParenthesesL1(String target) {
        // 最大值
        int max = 0;
        // 栈容器
        Deque<Integer> stack = new LinkedList<>();
        // 默认索引
        stack.push(-1);
        for (int i = 0; i < target.length(); i++) {
            // 当为左括号时
            if (target.charAt(i) == '(') {
                // 将下标入栈
                stack.push(i);
            } else {
                // 右括号时，先弹出
                stack.pop();
                // 如果为空，则入栈
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 否则，计算长度
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

}
