package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 最长有效括号
 */
public class LongestValidBrackets {

    /**
     * 最长有效括号长度
     *
     * @param target 目标字符串
     * @return 最长有效括号长度
     */
    public static int longestValidParentheses(String target) {
        if (target == null || target.length() < 2) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] ds = new boolean[target.length()];
        int[] bp = new int[target.length()];
        bp[0] = 0;
        ds[1] = target.charAt(0) == '(' && target.charAt(1) == ')';
        bp[1] = ds[1] ? 2 : 0;
        int longest = bp[1];
        if (bp[1] == 0) {
            stack.push(target.charAt(0));
            stack.push(target.charAt(1));
        }
        for (int i = 2; i < target.length(); i++) {
            if (!stack.isEmpty() && '(' == stack.peek() && target.charAt(i) == ')') {
                stack.pop();
                ds[i] = true;
                bp[i] = ds[i - 1] ? bp[i - 1] + 2 : Math.max(bp[i - 1], 2);
            } else {
                stack.push(target.charAt(i));
                bp[i] = bp[i - 1];
            }
            longest = Math.max(bp[i], longest);
        }
        return longest;
    }

    /**
     * 最长有效括号（动态规划）
     * <p>
     * 我们定义 \textit{dp}[i]dp[i] 表示以下标 ii 字符结尾的最长有效括号的长度。我们将 \textit{dp}dp 数组全部初始化为 00 。显然有效的子串一定以 \text{‘)’}‘)’ 结尾，因此我们可以知道以 \text{‘(’}‘(’ 结尾的子串对应的 \textit{dp}dp 值必定为 00 ，我们只需要求解 \text{‘)’}‘)’ 在 \textit{dp}dp 数组中对应位置的值。
     * <p>
     * 我们从前往后遍历字符串求解 \textit{dp}dp 值，我们每两个字符检查一次：
     * <p>
     * s[i] = \text{‘)’}s[i]=‘)’ 且 s[i - 1] = \text{‘(’}s[i−1]=‘(’，也就是字符串形如 “……()”“……()”，我们可以推出：
     * <p>
     * \textit{dp}[i]=\textit{dp}[i-2]+2
     * dp[i]=dp[i−2]+2
     * <p>
     * 我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 22 。
     * <p>
     * s[i] = \text{‘)’}s[i]=‘)’ 且 s[i - 1] = \text{‘)’}s[i−1]=‘)’，也就是字符串形如 “……))”“……))”，我们可以推出：
     * 如果 s[i - \textit{dp}[i - 1] - 1] = \text{‘(’}s[i−dp[i−1]−1]=‘(’，那么
     * <p>
     * \textit{dp}[i]=\textit{dp}[i-1]+\textit{dp}[i-\textit{dp}[i-1]-2]+2
     * dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     * <p>
     * 我们考虑如果倒数第二个 \text{‘)’}‘)’ 是一个有效子字符串的一部分（记作 sub_ssub
     * s
     * ​
     * ），对于最后一个 \text{‘)’}‘)’ ，如果它是一个更长子字符串的一部分，那么它一定有一个对应的 \text{‘(’}‘(’ ，且它的位置在倒数第二个 \text{‘)’}‘)’ 所在的有效子字符串的前面（也就是 sub_ssub
     * s
     * ​
     * 的前面）。因此，如果子字符串 sub_ssub
     * s
     * ​
     * 的前面恰好是 \text{‘(’}‘(’ ，那么我们就用 22 加上 sub_ssub
     * s
     * ​
     * 的长度（\textit{dp}[i-1]dp[i−1]）去更新 \textit{dp}[i]dp[i]。同时，我们也会把有效子串 “(sub_s)”“(sub
     * s
     * ​
     * )” 之前的有效子串的长度也加上，也就是再加上 \textit{dp}[i-\textit{dp}[i-1]-2]dp[i−dp[i−1]−2]。
     *
     * @param target 目标字符串
     * @return 最长长度
     */
    public static int longestValidParenthesesL0(String target) {
        // 最大值
        int max = 0;
        // 运行时缓存
        int[] dp = new int[target.length()];
        // 遍历
        for (int i = 1; i < target.length(); i++) {
            // 判断是否为右括号
            if (target.charAt(i) == ')') {
                // 判断前位是否为左括号
                if (target.charAt(i - 1) == '(') {
                    // 计算前值+2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && target.charAt(i - dp[i - 1] - 1) == '(') {
                    // 连接前一个+之前的值+2
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                // 取最大者
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * 最长有效括号（栈）
     *
     * @param target 目标字符串
     * @return 最长长度
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

    /**
     * 最长有效括号（双指针）
     *
     * @param target 目标字符串
     * @return 最长长度
     */
    public static int longestValidParenthesesL2(String target) {
        // 左括号数量 右括号数量 最大长度
        int left = 0, right = 0, max = 0;
        // 左遍历
        for (int i = 0; i < target.length(); i++) {
            // 计算括号数
            if (target.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            // 当左右相等时
            if (left == right) {
                // 最大值
                max = Math.max(max, 2 * right);
                // 当右括号数量大于左括号时，说明统计回置
            } else if (right > left) {
                left = right = 0;
            }
        }
        // 回置
        left = right = 0;
        // 右遍历
        for (int i = target.length() - 1; i >= 0; i--) {
            if (target.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }


    public static void main(String[] args) {
//        String[] targets = {"", "(", "()", "(()", "()(()","(()()","(((()))("};
//        for (String target : targets) {
//            System.out.println(longestValidParentheses(target));
//        }

        String target = "(()()";
        System.out.println(longestValidParenthesesL0(target));
        System.out.println(longestValidParenthesesL1(target));
        System.out.println(longestValidParenthesesL2(target));
    }

}
