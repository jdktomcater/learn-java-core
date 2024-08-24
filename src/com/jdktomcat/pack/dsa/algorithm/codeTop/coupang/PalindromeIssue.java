package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.HashMap;
import java.util.Map;

/**
 * 回文主题
 */
public class PalindromeIssue {

    /**
     * 最长回文子字符串
     *
     * @param target 目标字符串
     * @return 最长回文子字符串
     */
    public static String longestPalindrome(String target) {
        int[] max = {Integer.MIN_VALUE, 0, 0};
        for (int i = 0; i < target.length(); i++) {
            int[] max1 = palindromeLength(target, i, i);
            if (max[0] < max1[0]) {
                max = max1;
            }
            int[] max2 = palindromeLength(target, i, i + 1);
            if (max[0] < max2[0]) {
                max = max2;
            }
        }
        return target.substring(max[1], max[2]);
    }

    /**
     * 回文长度
     *
     * @param target 目标字符串
     * @param left   左起点
     * @param right  右起点
     * @return 回文长度
     */
    private static int[] palindromeLength(String target, int left, int right) {
        int len = 0;
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex >= 0 && rightIndex < target.length() && target.charAt(leftIndex) == target.charAt(rightIndex)) {
            len += (leftIndex == rightIndex ? 1 : 2);
            leftIndex--;
            rightIndex++;
        }
        if (left != right) {
            return new int[]{len, left - len / 2 + 1, right + len / 2};
        }
        return new int[]{len, left - len / 2, right + len / 2 + 1};
    }

    /**
     * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
     *
     * @param s 字符串
     * @return true：可以 false：不可以
     */
    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        int odd = 0;
        for (char ch : countMap.keySet()) {
            int count = countMap.get(ch);
            if (count % 2 != 0) {
                if(odd==0){
                    odd ++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String target = "babad";
        System.out.println(longestPalindrome(target));
    }
}
