package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 移掉K位数字
 */
public class RemoveByteNumber {

    /**
     * 移掉 K 位数字：贪心 + 单调栈
     *
     * @param num 数字
     * @param k   目标位数
     * @return 最小数字
     */
    public static String removeKdigitsL0(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); ++i) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > num.charAt(i)) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(num.charAt(i));
        }
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }


    /**
     * 移掉 K 位数字
     *
     * @param num 数字
     * @param k   目标位数
     * @return 最小数字
     */
    public static String removeKdigits(String num, int k) {
        StringBuilder number = new StringBuilder(num);
        String[] result = {num};
        dfs(number, 0, k, result);
        return result[0];
    }

    /**
     * 深度遍历计算逻辑
     *
     * @param number 数字
     * @param index  索引
     * @param count  次数
     */
    private static void dfs(StringBuilder number, int index, int count, String[] result) {
        if (count == 0) {
            result[0] = Math.min(Integer.parseInt(result[0]), parse(number.toString())) + "";
        } else if (index < number.length()) {
            dfs(number, index + 1, count, result);
            char ch = number.charAt(index);
            number.deleteCharAt(index);
            dfs(number, index, count - 1, result);
            number.insert(index, ch);
        }
    }

    /**
     * 字符串数字化
     *
     * @param number 字符串
     * @return 数字
     */
    private static int parse(String number) {
        int nZeroStartIndex = -1;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                nZeroStartIndex = i;
                break;
            }
        }
        return nZeroStartIndex == -1 ? 0 : Integer.parseInt(number.substring(nZeroStartIndex));
    }

    /**
     * 字符串数字化
     *
     * @param number 字符串
     * @return 数字
     */
    private static String format(String number) {
        int nZeroStartIndex = -1;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                nZeroStartIndex = i;
                break;
            }
        }
        return nZeroStartIndex == -1 ? "0" : number.substring(nZeroStartIndex);
    }

    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigitsL0(num, k));
    }
}
