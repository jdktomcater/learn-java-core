package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

/**
 * 菲波那切数列问题的递归和动态规划
 * f(n) = {
 * 0,n=0
 * 1,n=1,2
 * f(n-1)+f(n-2),n>2
 * }
 * <p>
 * 如果递归式严格符合f(n) = a*f(n-1)+b*f(n-2)+......+k*f(n-i)，
 * 则它就是一个i阶的递推式，必然有与i*i的状态矩阵有关的矩阵乘法的表达，
 * 一律可以用加速矩阵乘法的动态规划将时间复杂度降为O(log(n))
 */
public class FibonacciIssue {

    /**
     * 暴力直观实现(递归回溯 O(2^n))
     *
     * @param n 目标数字
     * @return 结果
     */
    public static int fi0(int n) {
        if (n < 2) {
            return n;
        }
        return fi0(n - 1) + fi0(n - 2);
    }

    /**
     * 动态规划(O(n))
     *
     * @param n 目标数字
     * @return 结果
     */
    public static int fi1(int n) {
        if (n < 2) {
            return n;
        }
        int res = 1, pre = 0, temp;
        for (int i = 1; i < n; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }
        return res;
    }

    /**
     * 矩阵阶乘法（O(log(n))）
     *
     * @param n 目标数字
     * @return 结果
     */
    public static int fi2(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] rst = matrixPower(base, n - 2);
        return rst[0][0] + rst[1][0];
    }

    /**
     * 矩阵阶乘
     * (f(n),f(n-1)) = (f(2),f(1)) * {{1,1},{1,0}} ^ n-2
     *
     * @param m 矩阵
     * @param p 阶乘
     * @return 结果矩阵
     */
    private static int[][] matrixPower(int[][] m, int p) {
        int[][] rst = new int[m.length][m[0].length];
        // 先把res设为单位矩阵，相当于整数中的1
        for (int i = 0; i < rst.length; i++) {
            rst[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                rst = muliMatrix(rst, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return rst;
    }

    /**
     * 矩阵相乘
     *
     * @param m1 矩阵1
     * @param m2 矩阵2
     * @return 结果矩阵
     */
    private static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] rst = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    rst[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return rst;
    }

    /**
     * 爬到台阶n（一次可以爬1个台阶、2个台阶）总走法(递归回溯)
     *
     * @param n 目标台阶
     * @return 总走法
     */
    public static int s0(int n) {
        if (n < 3) {
            return n;
        }
        return s0(n - 1) + s0(n - 2);
    }

    /**
     * 爬到台阶n（一次可以爬1个台阶、2个台阶）总走法(动态规划)
     *
     * @param n 目标台阶
     * @return 总走法
     */
    public static int s1(int n) {
        if (n < 3) {
            return n;
        }
        int rst = 2, pre = 1, temp;
        for (int i = 3; i <= n; i++) {
            temp = rst;
            rst = rst + pre;
            pre = temp;
        }
        return rst;
    }

    /**
     * 矩阵阶乘
     * (f(n),f(n-1)) = (f(2),f(1)) * {{1,1},{1,0}} ^ n-2
     *
     * @param n 目标数组
     * @return 结果
     */
    public static int s2(int n) {
        if (n < 3) {
            return n;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] rst = matrixPower(base, n - 2);
        return 2 * rst[0][0] + rst[1][0];
    }

    /**
     * 农场牛数量：(递归回溯)
     * c(n) = {
     * n,n<4
     * c(n-1)+c(n-3),n>=4
     * }
     *
     * @param n 目标年数
     * @return 牛的数量
     */
    public static int c0(int n) {
        if (n < 4) {
            return n;
        }
        return c0(n - 1) + c0(n - 3);
    }

    /**
     * 农场牛数量：(动态规划)
     * c(n) = {
     * n,n<4
     * c(n-1)+c(n-3),n>=4
     * }
     *
     * @param n 目标年数
     * @return 牛的数量
     */
    public static int c1(int n) {
        if (n < 4) {
            return n;
        }
        int rst = 3, pre = 2, prePre = 1, temp1, temp2;
        for (int i = 4; i <= n; i++) {
            temp1 = rst;
            temp2 = pre;
            rst = rst + prePre;
            pre = temp1;
            prePre = temp2;
        }
        return rst;
    }

    /**
     * 农场牛数量：(三矩阵阶乘)
     * （c(n),c(n-1),c(n-2)） = (c(3),c(2),c(1))*{{1,1,0},{0,0,1},{1,0,0}}^(n-3)
     *
     * @param n 目标年数
     * @return 牛的数量
     */
    public static int c2(int n) {
        if (n < 4) {
            return n;
        }
        int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] res = matrixPower(base, n - 3);
        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
    }


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(c2(i));
        }
    }
}
