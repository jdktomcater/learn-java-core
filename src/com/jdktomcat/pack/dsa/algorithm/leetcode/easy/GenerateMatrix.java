package com.jdktomcat.pack.dsa.algorithm.leetcode.easy;

/**
 * 类描述：生成螺旋矩阵
 *
 * @author 11072131
 * @date 2020-01-2020/1/11 17:26
 */
public class GenerateMatrix {

    public static int[][] generateMatrix(int n) {
        int targetNumber = n * n;
        int[][] data = new int[n][n];
        int vertical = 0;
        int horizontal = 1;
        int target = 1;
        int index_x = 0;
        int index_y = 0;
        while (true) {
            data[index_x][index_y] = target;
            target++;
            index_x += horizontal;
            index_y += vertical;
            if (data[index_x][index_y] != 0) {

            }
            break;
        }
        return data;
    }
}
