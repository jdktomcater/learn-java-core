package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 岛屿相关问题
 */
public class IslandIssue {

    /**
     * 岛屿数量
     *
     * @param info 岛屿信息
     * @return 岛屿数量
     */
    public static int count(int[][] info) {
        // 结果
        int count = 0;
        // 辅助记录遍历标识
        boolean[][] dp = new boolean[info.length][info[0].length];
        // 方向
        int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 遍历统计
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[0].length; j++) {
                // 判断逻辑
                if (!dp[i][j] && info[i][j] == 1) {
                    count++;
                    travel(info, dp, directs, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 遍历标识
     *
     * @param info 岛屿信息
     * @param dp   遍历状态信息
     * @param r    行
     * @param c    列
     */
    private static void travel(int[][] info, boolean[][] dp, int[][] directs, int r, int c) {
        // 遍历标识设置
        dp[r][c] = true;
        // 长度
        int row = info.length;
        // 宽度
        int col = info[0].length;
        // 沿着方向行走遍历
        for (int[] dir : directs) {
            // 临近点行坐标
            int nr = dir[0] + r;
            // 临近点纵坐标
            int nc = dir[1] + c;
            // 判断临界条件
            if (nr >= 0 && nr < row && nc >= 0 && nc < col && info[nr][nc] == 1 && !dp[nr][nc]) {
                // 深度遍历
                travel(info, dp, directs, nr, nc);
            }
        }
    }

    /**
     * 岛屿最大面积
     *
     * @param grid 岛屿信息
     * @return 岛屿最大面积
     */
    public static int maxAreaOfIsland(int[][] grid) {
        // 结果
        int max = 0;
        // 辅助记录遍历标识
        boolean[][] dp = new boolean[grid.length][grid[0].length];
        // 方向
        int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 遍历统计
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 判断逻辑
                if (!dp[i][j] && grid[i][j] == 1) {
                    int[] area = {1};
                    travelArea(grid, dp, directs, i, j, area);
                    max = Math.max(max, area[0]);
                }
            }
        }
        return max;
    }

    /**
     * 遍历标识
     *
     * @param info    岛屿信息
     * @param dp      遍历状态信息
     * @param directs 方向信息
     * @param r       行
     * @param c       列
     * @param area    面积
     */
    private static void travelArea(int[][] info, boolean[][] dp, int[][] directs, int r, int c, int[] area) {
        // 遍历标识设置
        dp[r][c] = true;
        // 长度
        int row = info.length;
        // 宽度
        int col = info[0].length;
        // 沿着方向行走遍历
        for (int[] dir : directs) {
            // 临近点行坐标
            int nr = dir[0] + r;
            // 临近点纵坐标
            int nc = dir[1] + c;
            // 判断临界条件
            if (nr >= 0 && nr < row && nc >= 0 && nc < col && info[nr][nc] == 1 && !dp[nr][nc]) {
                // 面积统计
                area[0]++;
                // 深度遍历
                travelArea(info, dp, directs, nr, nc, area);
            }
        }
    }

    /**
     * 使陆地分离的最少天数（结果只有0,1,2）
     * <p>
     * 给你一个由若干 0 和 1 组成的二维网格 grid ，其中 0 表示水，而 1 表示陆地。
     * 岛屿由水平方向或竖直方向上相邻的 1 （陆地）连接形成。
     * 如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则，陆地就是 分离的 。
     * 一天内，可以将任何单个陆地单元（1）更改为水单元（0）。
     * 返回使陆地分离的最少天数。
     *
     * @param grid 岛屿信息
     * @return 使陆地分离的最少天数
     */
    public static int minDays(int[][] grid) {
        int count = count(grid);
        if (count == 1) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        count = count(grid);
                        if (count != 1) {
                            return 1;
                        }
                        grid[i][j] = 1;
                    }
                }
            }
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
