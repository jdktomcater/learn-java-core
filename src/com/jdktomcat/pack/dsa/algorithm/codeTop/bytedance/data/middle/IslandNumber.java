package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

/**
 * 岛屿数量
 */
public class IslandNumber {

    /**
     * 岛屿数量
     *
     * @param grid 岛屿信息
     * @return 岛屿数量
     */
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    travel(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 遍历
     *
     * @param grid 岛屿信息
     * @param i    横左边
     * @param j    纵坐标
     */
    private static void travel(char[][] grid, int i, int j) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1')) {
            return;
        }
        grid[i][j] = '0';
        travel(grid, i + 1, j);
        travel(grid, i - 1, j);
        travel(grid, i, j + 1);
        travel(grid, i, j - 1);
    }
}
