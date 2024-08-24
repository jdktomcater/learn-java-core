package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

/**
 * 旋转矩阵
 */
public class RotateMatrix {
    /**
     * 旋转矩阵
     *
     * @param matrix 矩阵信息
     */
    public static void rotate(int[][] matrix) {
        int board = matrix.length;
        for (int i = 0; i < board / 2; i++) {
            for (int j = 0; j < (board + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[board - j - 1][i];
                matrix[board - j - 1][i] = matrix[board - i - 1][board - j - 1];
                matrix[board - i - 1][board - j - 1] = matrix[j][board - i - 1];
                matrix[j][board - i - 1] = temp;
            }
        }
    }

}
