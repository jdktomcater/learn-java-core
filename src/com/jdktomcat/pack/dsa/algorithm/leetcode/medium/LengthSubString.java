package com.jdktomcat.pack.dsa.algorithm.leetcode.medium;

/**
 * 类描述：无重复字符的最长子串
 *
 * @author 汤旗
 * @date 2019-08-19 20:34
 */
public class LengthSubString {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s != null) {
            int length = s.length();
            for (int i = 0; i < length; i++) {
                int num = 1;
                for (int j = i + 1; j < length; j++) {
                    if (s.substring(i, j).indexOf(s.charAt(j)) == -1) {
                        num++;
                    } else {
                        break;
                    }
                }
                max = Math.max(max, num);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

}
