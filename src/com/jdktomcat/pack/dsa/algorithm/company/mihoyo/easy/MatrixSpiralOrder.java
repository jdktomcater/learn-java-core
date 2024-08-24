package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.easy;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 */
public class MatrixSpiralOrder {

    /**
     * 顺时针打印矩阵
     *
     * @param matrix 矩阵信息
     * @return 顺时针打印矩阵
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length, col = matrix[0].length;
        int[] order = new int[row * col];
        boolean[][] visited = new boolean[row][col];
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int di = 0, index = 0, ri = 0, ci = 0;
        while (index < order.length) {
            order[index++] = matrix[ri][ci];
            visited[ri][ci] = true;
            int[] dir = directs[di % directs.length];
            int nr = ri + dir[0], nc = ci + dir[1];
            if (!(nr >= 0 && nr < row && nc >= 0 && nc < col) || visited[nr][nc]) {
                dir = directs[(++di) % directs.length];
            }
            ri += dir[0];
            ci += dir[1];
        }
        return order;
    }

}
