package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

import java.util.Arrays;

/**
 * 螺旋矩阵 II
 */
public class GenerateMatrix {

    /**
     * 螺旋矩阵 II
     *
     * @param n 边长
     * @return 矩阵
     */
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int ri = 0, ci = 0, di = 0, index = 0;
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (index < n * n) {
            matrix[ri][ci] = index + 1;
            int[] dir = directs[di % directs.length];
            int nr = ri + dir[0], nc = ci + dir[1];
            if (!(nr >= 0 && nr < n && nc >= 0 && nc < n) || matrix[nr][nc] != 0) {
                dir = directs[(++di) % directs.length];
            }
            ri += dir[0];
            ci += dir[1];
            index++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(n);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
