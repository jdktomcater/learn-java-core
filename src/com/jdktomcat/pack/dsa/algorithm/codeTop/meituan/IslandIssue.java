package com.jdktomcat.pack.dsa.algorithm.codeTop.meituan;

/**
 * 小岛相关问题
 */
public class IslandIssue {

    /**
     * 小岛最大面积
     *
     * @param grid 小岛信息
     * @return 最大面积
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, travel(grid, i, j));
                }
            }
        }
        return max;
    }

    /**
     * 遍历后返回小岛面积
     *
     * @param grid 小岛信息
     * @param i    横坐标
     * @param j    竖坐标
     * @return 面积
     */
    private static int travel(int[][] grid, int i, int j) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1)) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += travel(grid, i + 1, j);
        area += travel(grid, i, j + 1);
        area += travel(grid, i - 1, j);
        area += travel(grid, i, j - 1);
        return area;
    }
}
