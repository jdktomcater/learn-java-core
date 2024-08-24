package com.jdktomcat.interview.google;

public class MaxRectangle {

    private static int max(int[][] matrix, int i, int j) {
        int mr = 0, mc = 0;
        while (mr + i < matrix.length && matrix[mr + i][j] == 1) {
            mr++;
        }
        while (mc + j < matrix[0].length && matrix[i][mc + j] == 1) {
            mc++;
        }
        int max = mc;
        for (int c = j; c < mc + j; c++) {
            int subMax = 0;
            for (int r = i; r < mr + i; r++) {
                if (matrix[r][c] != 1) {
                    mc = c;
                    break;
                }
                subMax += mc;
            }
            max = Math.max(max, subMax);
        }
        return max;
    }


    public static int maximalRectangle(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    max = Math.max(max(matrix, i, j), max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(maximalRectangle(matrix));
    }
}
