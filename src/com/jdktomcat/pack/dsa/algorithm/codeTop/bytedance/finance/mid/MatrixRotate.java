package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

/**
 * 矩阵旋转
 */
public class MatrixRotate {

    /**
     * 矩阵旋转
     *
     * @param matrix 矩阵信息
     */
    public static void rotate(int[][] matrix) {
        int board = matrix.length;
        for (int i = 0; i < board / 2; i++) {
            for (int j = 0; j < (board + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[board - 1 - j][i];
                matrix[board - 1 - j][i] = matrix[board - 1 - i][board - 1 - j];
                matrix[board - 1 - i][board - 1 - j] = matrix[j][board - 1 - i];
                matrix[j][board - 1 - i] = temp;
            }
        }
    }
}
