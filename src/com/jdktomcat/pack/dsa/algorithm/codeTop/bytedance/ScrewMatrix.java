package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class ScrewMatrix {

    static final int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 螺旋矩阵访问顺序列表
     *
     * @param matrix 矩阵
     * @return 螺旋矩阵访问顺序列表
     */
    public static List<Integer> spiralOrderL1(int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        boolean[][] dp = new boolean[matrix.length][matrix[0].length];
        travel(matrix, dp, result, 0, 0, 0);
        return result;
    }

    /**
     * 遍历
     *
     * @param matrix 矩阵
     * @param dp     标识
     * @param result 结果
     * @param dir    方向
     * @param i      行下标
     * @param j      列下标
     */
    private static void travel(int[][] matrix, boolean[][] dp, List<Integer> result, int dir, int i, int j) {
        result.add(matrix[i][j]);
        dp[i][j] = true;
        if (result.size() == matrix.length * matrix[0].length) {
            return;
        }
        int nr = i + directs[dir % 4][0];
        int nc = j + directs[dir % 4][1];
        if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && !dp[nr][nc]) {
            travel(matrix, dp, result, dir, nr, nc);
        } else {
            int tr = i + directs[(dir + 1) % 4][0];
            int tc = j + directs[(dir + 1) % 4][1];
            if (tr >= 0 && tr < matrix.length && tc >= 0 && tc < matrix[0].length && !dp[tr][tc]) {
                travel(matrix, dp, result, dir + 1, tr, tc);
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
    }


}
