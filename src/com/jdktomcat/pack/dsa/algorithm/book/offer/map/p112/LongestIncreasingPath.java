package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p112;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 最长递增路径
 */
public class LongestIncreasingPath {

    /**
     * 遍历
     *
     * @param matrix 数据矩阵
     * @param result 结果路径
     * @param r      行
     * @param c      列
     */
    private static void bfs(int[][] matrix, List<Integer> result, int r, int c) {
        result.add(matrix[r][c]);
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<Integer> longList = new LinkedList<>();
        for (int[] dir : dirs) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (nextR >= 0 && nextC >= 0 && nextR < row && nextC < col && matrix[nextR][nextC] > matrix[r][c]) {
                List<Integer> tempList = new LinkedList<>();
                bfs(matrix, tempList, nextR, nextC);
                if (tempList.size() > longList.size()) {
                    longList = tempList;
                }
            }
        }
        result.addAll(longList);
    }

    /**
     * 计算最长递增路径
     *
     * @param matrix 数据矩阵
     * @return 最长递增路径
     */
    public static List<Integer> longestIncreasingPath(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                List<Integer> path = new LinkedList<>();
                bfs(matrix, path, i, j);
                if (path.size() > result.size()) {
                    result = path;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 4, 5}, {3, 2, 8}, {2, 2, 1}};
        List<Integer> result = longestIncreasingPath(matrix);
        System.out.println("最长递增路径：" + Arrays.toString(result.toArray()));
    }
}
