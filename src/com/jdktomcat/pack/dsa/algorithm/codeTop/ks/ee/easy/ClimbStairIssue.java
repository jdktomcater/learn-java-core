package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.easy;

/**
 * 爬楼梯相关主题
 */
public class ClimbStairIssue {

    /**
     * 爬楼梯方案数
     *
     * @param n 楼梯数
     * @return 总方案数
     */
    public static int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int pre0 = 1, pre = 1;
        for (int i = 2; i <= n; i++) {
            int temp = pre;
            pre += pre0;
            pre0 = temp;
        }
        return pre;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

}
