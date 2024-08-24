package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p107;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 107:矩阵中的距离
 * <p>
 * Q：输入一个由0、1组成的矩阵，输出一个大小相同的矩阵D。矩阵D中每个格子是矩阵M中距离最近0的距离。
 */
public class LengthMatrix {

    /**
     * 转化矩阵
     *
     * @param source 原始矩阵
     * @return 转化后的矩阵
     */
    public static int[][] updateMatrix(int[][] source) {
        int row = source.length;
        int col = source[0].length;
        int[][] dists = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (source[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    dists[i][j] = 0;
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int dist = dists[pos[0]][pos[1]];
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && c >= 0 && r < row && c < col) {
                    if (dists[r][c] > dist + 1) {
                        dists[r][c] = dist + 1;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return dists;
    }

    public static void main(String[] args) {
        int[][] M = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] D = updateMatrix(M);
        for (int[] num : D) {
            System.out.println(Arrays.toString(num));
        }
    }
}
