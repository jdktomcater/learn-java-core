package com.jdktomcat.pack.dsa.algorithm.codeTop.pdd.mock;

public class Mock20220816 {
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

    /**
     * 统计小岛个数
     *
     * @param grid 岛屿信息
     * @return 小岛个数
     */
    private static int countL0(int[][] grid, int[][] connections) {
        int count = 0;
        boolean[][] status = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!status[i][j] && grid[i][j] == 1) {
                    count++;
                    travelL0(grid, status, i, j);
                    if (i < grid.length - 1 && status[i + 1][j]) {
                        connections[i][j]++;
                    }
                    if (i > 0 && status[i - 1][j]) {
                        connections[i][j]++;
                    }
                    if (j < grid[0].length - 1 && status[i][j + 1]) {
                        connections[i][j]++;
                    }
                    if (j > 0 && status[i][j - 1]) {
                        connections[i][j]++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 遍历
     *
     * @param grid   岛屿信息
     * @param status 遍历状态
     * @param i      横坐标
     * @param j      竖坐标
     */
    private static void travelL0(int[][] grid, boolean[][] status, int i, int j) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !status[i][j])) {
            return;
        }
        if (grid[i][j] == 1) {
            status[i][j] = true;
        }
        travel(grid, status, i + 1, j);
        travel(grid, status, i - 1, j);
        travel(grid, status, i, j + 1);
        travel(grid, status, i, j - 1);
    }

    /**
     * 统计小岛个数
     *
     * @param grid 岛屿信息
     * @return 小岛个数
     */
    private static int count(int[][] grid) {
        int count = 0;
        boolean[][] status = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!status[i][j] && grid[i][j] == 1) {
                    count++;
                    travel(grid, status, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 遍历
     *
     * @param grid   岛屿信息
     * @param status 遍历状态
     * @param i      横坐标
     * @param j      竖坐标
     */
    private static void travel(int[][] grid, boolean[][] status, int i, int j) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !status[i][j])) {
            return;
        }
        status[i][j] = true;
        travel(grid, status, i + 1, j);
        travel(grid, status, i - 1, j);
        travel(grid, status, i, j + 1);
        travel(grid, status, i, j - 1);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static int minDaysL0(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // 岛屿数量不为 1，陆地已经分离
        if (count(grid, n, m) != 1) {
            return 0;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 0) {
                    grid[i][j] = 0;
                    if (count(grid, n, m) != 1) {
                        // 更改一个陆地单元为水单元后陆地分离
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public static int count(int[][] grid, int n, int m) {
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    cnt++;
                    dfs(i, j, grid, n, m);
                }
            }
        }
        // 还原
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y, int[][] grid, int n, int m) {
        grid[x][y] = 2;
        for (int i = 0; i < 4; ++i) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] != 1) {
                continue;
            }
            dfs(tx, ty, grid, n, m);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {1, 1}};
        System.out.println(minDays(grid));
    }
}
