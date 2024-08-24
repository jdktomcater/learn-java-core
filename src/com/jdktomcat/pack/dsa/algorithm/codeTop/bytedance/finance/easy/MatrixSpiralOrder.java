package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

import java.util.Arrays;

/**
 * 顺时针打印矩阵
 */
public class MatrixSpiralOrder {

    /**
     * 顺时针打印矩阵
     *
     * @param matrix 矩阵
     * @return 顺序
     */
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int row = matrix.length, col = matrix[0].length;
        int[] order = new int[row * col];
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[row][col];
        int index = 0, ri = 0, ci = 0, di = 0;
        while (index < order.length) {
            order[index++] = matrix[ri][ci];
            visited[ri][ci] = true;
            int[] dir = directs[di % 4];
            int nr = ri + dir[0], nc = ci + dir[1];
            if (!(nr >= 0 && nr < row && nc >= 0 && nc < col) || visited[nr][nc]) {
                dir = directs[(++di) % 4];
            }
            ri += dir[0];
            ci += dir[1];
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] order = spiralOrder(matrix);
        System.out.println(Arrays.toString(order));
    }

}
