package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class SpiralOrderMatrix {

    /**
     * 螺旋矩阵访问顺序列表
     *
     * @param matrix 矩阵
     * @return 螺旋矩阵访问顺序列表
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        // 顺序
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

}
