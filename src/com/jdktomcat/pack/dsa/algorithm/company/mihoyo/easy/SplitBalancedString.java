package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.easy;

/**
 * 分割平衡字符串
 */
public class SplitBalancedString {

    /**
     * 分割平衡字符串
     *
     * @param s 目标字符串
     * @return 分割平衡字符串
     */
    public static int balancedStringSplit(String s) {
        int lc = 0, rc = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lc++;
            } else {
                rc++;
            }
            if (lc == rc) {
                count++;
            }
        }
        return count;
    }
}
