package com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p40;

import com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p39.LargestRectangleArea;

/**
 * 矩阵中的最大矩形
 */
public class MaximalRectangle {

    /**
     * 矩阵中的最大矩形
     *
     * @param matrix 矩阵信息
     * @return 最大矩形
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '0') {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
            maxArea = Math.max(maxArea, LargestRectangleArea.largestRectangleAreaL1(heights));
        }
        return maxArea;
    }
}
