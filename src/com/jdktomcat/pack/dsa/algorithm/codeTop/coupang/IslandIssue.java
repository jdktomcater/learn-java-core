package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

/**
 *  岛屿相关问题
 */
public class IslandIssue {

    /**
     * 岛屿数量
     *
     * @param grid 岛屿信息
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    travel(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 遍历岛屿信息
     *
     * @param grid 岛屿信息
     * @param i 岛行坐标
     * @param j 岛纵坐标
     */
    private void travel(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '1') {
            // 抹去
            grid[i][j] = '0';
        }
        travel(grid, i + 1, j);
        travel(grid, i, j + 1);
        travel(grid, i - 1, j);
        travel(grid, i, j - 1);
    }
}
