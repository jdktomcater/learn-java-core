package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        String target = strs[0];
        if (target.length() == 0) {
            return "";
        }
        while (index < target.length()) {
            String prefix = target.substring(0, index + 1);
            boolean flag = true;
            for (String str : strs) {
                if (str.length() < prefix.length() || !str.startsWith(prefix)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                index++;
            } else {
                break;
            }
        }
        return target.substring(0, index);
    }

    public static void main(String[] args) {
        String[] strs = {"a"};
        System.out.println(longestCommonPrefix(strs));
    }

}
