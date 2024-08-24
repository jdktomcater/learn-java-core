package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p86;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回文分割
 */
public class PalindromePartition {

    /**
     * 分割回文子字符串
     *
     * @param target 目标字符串
     * @return 回文子字符串
     */
    public static List<List<String>> partition(String target) {
        List<List<String>> result = new LinkedList<>();
        helper(target, 0, new LinkedList<>(), result);
        return result;
    }

    /**
     * 循环计算体
     *
     * @param target     目标值
     * @param start      开始索引
     * @param palindrome 回文
     * @param result     结果列表
     */
    private static void helper(String target, int start, LinkedList<String> palindrome, List<List<String>> result) {
        if (start == target.length()) {
            result.add(new LinkedList<>(palindrome));
            return;
        }
        for (int i = start; i < target.length(); i++) {
            if (isPalindrome(target, start, i)) {
                palindrome.add(target.substring(start, i + 1));
                helper(target, i + 1, palindrome, result);
                palindrome.removeLast();
            }
        }
    }

    /**
     * 判断是否是回文
     *
     * @param target 目标字符串
     * @param start  开始索引
     * @param end    结束索引
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

    public static void main(String[] args) {
        String target = "google";
        List<List<String>> result = partition(target);
        for (List<String> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}
