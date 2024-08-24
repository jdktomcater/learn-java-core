package com.jdktomcat.pack.dsa.algorithm.book.guide.dp;

/**
 * 汉诺塔问题
 */
public class HanoiIssue {

    /**
     * 汉诺塔问题求解
     *
     * @param n 盘子个数
     */
    public static void hanoi(int n) {
        if (n <= 0) {
            return;
        }
        move(n, "left", "mid", "to");
    }

    /**
     * 汉诺塔移动逻辑
     *
     * @param n    盘子个数
     * @param from 源柱
     * @param mid  中间柱
     * @param to   目标柱
     */
    public static void move(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println("move from " + from + " to " + to);
        } else {
            move(n - 1, from, to, mid);
            move(1, from, mid, to);
            move(n - 1, mid, from, to);
        }
    }

    public static void main(String[] args) {
        hanoi(10);
    }

}
