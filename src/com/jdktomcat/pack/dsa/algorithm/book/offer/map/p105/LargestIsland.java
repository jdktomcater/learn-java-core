package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p105;

/**
 * 最大岛屿：
 * <p>
 * Q:海洋岛屿地图0,1
 * 横竖为1则为岛屿，求最大岛屿面积
 * <p>
 * I：[
 * [1,1,0,0,1],
 * [1,0,0,1,0],
 * [1,1,0,1,0],
 * [0,0,1,0,0]
 * ]
 * <p>
 * O:5
 */
public class LargestIsland {

    /**
     * 遍历图
     *
     * @param islandGraph 图信息
     * @param visited     访问信息
     * @param cow         行
     * @param col         列
     */
    private static int getArea(int[][] islandGraph, boolean[][] visited, int cow, int col) {
        int area = 1;
        visited[cow][col] = true;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int cowSize = islandGraph.length;
        int colSize = islandGraph[0].length;
        for (int[] dir : dirs) {
            int cowDir = cow + dir[0];
            int colDir = col + dir[1];
            if (cowDir >= 0 && colDir >= 0 && cowDir < cowSize && colDir < colSize && islandGraph[cowDir][colDir] == 1 && !visited[cowDir][colDir]) {
                area += getArea(islandGraph, visited, cowDir, colDir);
            }
        }
        return area;
    }


    /**
     * 计算最大岛屿面积
     *
     * @param islandGraph 岛屿分布信息
     * @return 最大面积
     */
    public static int[] largestIsland(int[][] islandGraph) {
        int[] info = new int[2];
        int cows = islandGraph.length;
        int cols = islandGraph[0].length;
        boolean[][] visited = new boolean[cows][cols];
        for (int cow = 0; cow < cows; cow++) {
            for (int col = 0; col < cols; col++) {
                if (islandGraph[cow][col] == 1 && !visited[cow][col]) {
                    info[0] = Math.max(info[0], getArea(islandGraph, visited, cow, col));
                    info[1]++;
                }
            }
        }
        return info;
    }


    public static void main(String[] args) {
        int[][] islandGraph = {
                {1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 0}
        };
        int[] info = largestIsland(islandGraph);
        System.out.println("最大岛屿面积：" + info[0]);
        System.out.println("岛屿数量：" + info[1]);
    }

}
