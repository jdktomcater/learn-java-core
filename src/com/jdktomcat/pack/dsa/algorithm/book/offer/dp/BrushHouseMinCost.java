package com.jdktomcat.pack.dsa.algorithm.book.offer.dp;


/**
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * <p>
 * 请计算出粉刷完所有房子最少的花费成本。
 * <p>
 * 示例 1：
 * <p>
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 * 最少花费: 2 + 5 + 3 = 10。
 * 示例 2：
 * <p>
 * 输入: costs = [[7,6,2]]
 * 输出: 2
 * <p>
 * 提示:
 * <p>
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 */
public class BrushHouseMinCost {

    /**
     * 粉刷房子
     *
     * @param house 粉刷代价
     * @return 最小耗费
     */
    public static int brush(int[][] house) {
        int length = house.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[2];
        for (int index = 0; index < length; index++) {
            int selectColor = 0;
            int min = house[index][0];
            for (int color = 0; color < house[index].length; color++) {
                if (color != dp[0] && house[index][color] < min) {
                    min = house[index][color];
                    selectColor = color;
                }
            }
            dp[0] = selectColor;
            dp[1] += min;
        }
        return dp[1];
    }

    public static void main(String[] args) {
        int[] house1 = new int[]{17, 2, 17};
        int[] house2 = new int[]{16, 16, 5};
        int[] house3 = new int[]{14, 3, 19};
        int[][] house = new int[][]{house1, house2, house3};
        System.out.println(brush(house));
    }


}
