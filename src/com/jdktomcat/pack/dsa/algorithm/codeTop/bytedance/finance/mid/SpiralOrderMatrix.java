package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class SpiralOrderMatrix {

    /**
     * 螺旋矩阵列表
     *
     * @param matrix 矩阵
     * @return 链表
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length, di = 0, ri = 0, ci = 0;
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row * col; i++) {
            visited[ri][ci] = true;
            order.add(matrix[ri][ci]);
            int[] direct = directs[di % 4];
            int nr = ri + direct[0], nc = ci + direct[1];
            if (!(nr >= 0 && nr < row && nc >= 0 && nc < col) || visited[nr][nc]) {
                direct = directs[(++di) % 4];
            }
            ri += direct[0];
            ci += direct[1];
        }
        return order;
    }
}
