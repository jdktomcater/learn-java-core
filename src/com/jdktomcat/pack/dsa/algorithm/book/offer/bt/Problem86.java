package com.jdktomcat.pack.dsa.algorithm.book.offer.bt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回文子字符串
 */
public class Problem86 {

    /**
     * 处理逻辑
     *
     * @param target     目标字符串
     * @param start      起始索引
     * @param substrings 子链表
     * @param result     结果
     */
    private static void helper(String target, int start, LinkedList<String> substrings, List<List<String>> result) {
        if (start == target.length()) {
            result.add(new LinkedList<>(substrings));
            return;
        }
        for (int index = start; index < target.length(); index++) {
            if (isPalindrome(target, start, index)) {
                substrings.add(target.substring(start, index + 1));
                helper(target, index + 1, substrings, result);
                substrings.removeLast();
            }
        }
    }

    /**
     * 判断是否是回文
     *
     * @param target 目标字符串
     * @param start  开始索引
     * @param end    截止索引
     * @return true：是 false：否
     */
    private static boolean isPalindrome(String target, int start, int end) {
        while (start < end) {
            if (target.charAt(start++) != target.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算回文字符串
     *
     * @param target 目标字符串
     * @return 列表
     */
    public static List<List<String>> partition(String target) {
        List<List<String>> result = new LinkedList<>();
        helper(target, 0, new LinkedList<>(), result);
        return result;
    }


    public static void main(String[] args) {
        String target = "google";
        List<List<String>> result = partition(target);
        for (List<String> sub : result) {
            System.out.println(Arrays.toString(sub.toArray()));
        }
    }
}
