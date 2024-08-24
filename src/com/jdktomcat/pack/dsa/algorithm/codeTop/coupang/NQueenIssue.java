package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenIssue {

    /**
     * n皇后问题
     *
     * @param num 皇后数量
     * @return 所有可行路径
     */
    public static List<List<String>> solveNQueens(int num) {
        boolean[][] points = new boolean[num][num];
        List<List<String>> result = new ArrayList<>();
        dfs(points, num, 0, result);
        return result;
    }

    /**
     * 深度遍历逻辑
     *
     * @param points 节点信息
     * @param nth    皇后剩余数
     * @param index  索引
     */
    private static void dfs(boolean[][] points, int nth, int index, List<List<String>> result) {
        if (nth == 0) {
            result.add(change(points));
        } else if (index < points.length) {
            if (isValid(points, points.length - nth, index)) {
                points[points.length - nth][index] = true;
                dfs(points, nth - 1, 0, result);
                points[points.length - nth][index] = false;
            }
            dfs(points, nth, index + 1, result);
        }
    }

    /**
     * 将状态数组转化为字符串列表
     *
     * @param points 状态数组
     * @return 字符串列表
     */
    private static List<String> change(boolean[][] points) {
        List<String> pointList = new ArrayList<>();
        for (boolean[] row : points) {
            StringBuilder sb = new StringBuilder();
            for (boolean point : row) {
                sb.append(point ? 'Q' : '.');
            }
            pointList.add(sb.toString());
        }
        return pointList;
    }


    /**
     * 校验戳点坐标（i,j） 是否能放置皇后
     *
     * @param points 全坐标信息
     * @param i      戳点横坐标
     * @param j      戳点竖坐标
     * @return true:可放 false:不可放
     */
    private static boolean isValid(boolean[][] points, int i, int j) {
        // 同列是否有Q
        boolean notExist = true;
        for (int n = 0; n < i && notExist; n++) {
            notExist = !points[n][j];
        }
        // 斜线是否有Q
        for (int n = 0; n <= i && n <= j && notExist; n++) {
            notExist = !points[i - n][j - n];
        }
        // 斜线是否有Q
        for (int n = 0; n <= i && n < points.length - j && notExist; n++) {
            notExist = !points[i - n][j + n];
        }
        return notExist;
    }



    /**
     * n皇后问题统计个数
     *
     * @param n 皇后个数
     * @return n皇后问题统计个数
     */
    public static int totalNQueens(int n) {
        boolean[][] points = new boolean[n][n];
        int[] result = {0};
        dfsCount(points, n, 0, result);
        return result[0];
    }

    /**
     * 深度遍历逻辑统计个数
     *
     * @param points 节点信息
     * @param nth    皇后剩余数
     * @param index  索引
     */
    private static void dfsCount(boolean[][] points, int nth, int index, int[] result) {
        if (nth == 0) {
            result[0]++;
        } else if (index < points.length) {
            if (isValid(points, points.length - nth, index)) {
                points[points.length - nth][index] = true;
                dfsCount(points, nth - 1, 0, result);
                points[points.length - nth][index] = false;
            }
            dfsCount(points, nth, index + 1, result);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        List<List<String>> result = solveNQueens(n);
        for (List<String> path : result) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
