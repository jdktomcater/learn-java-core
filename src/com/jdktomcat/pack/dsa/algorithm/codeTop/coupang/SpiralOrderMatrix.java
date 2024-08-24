package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrderMatrix {

    /**
     * 螺旋矩阵访问顺序列表
     *
     * @param matrix 矩阵
     * @return 螺旋矩阵访问顺序列表
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        int row = matrix.length, col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        int r = 0, c = 0;
        for (int i = 0; i < row * col; i++) {
            visited[r][c] = true;
            order.add(matrix[r][c]);
            int[] dir = directs[dirIndex % 4];
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (!(nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc])) {
                dir = directs[(++dirIndex) % 4];
            }
            r += dir[0];
            c += dir[1];
        }
        return order;
    }

    /**
     * 螺旋矩阵访问顺序列表
     *
     * @param matrix 矩阵
     * @return 螺旋矩阵访问顺序列表
     */
    public List<Integer> spiralOrderL0(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
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
