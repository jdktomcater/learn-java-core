package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p88;

import org.junit.Test;

public class ClimbStairCostTest {

    @Test
    public void minCostClimbStairsL4() {
        int[] cost = new int[]{1, 100, 1, 1, 100, 1};
        System.out.println("L4计算消耗成本：" + ClimbStairCost.minCostClimbStairsL4(cost));
    }

    @Test
    public void minCostClimbStairsL3() {
        int[] cost = new int[]{1, 100, 1, 1, 100, 1};
        System.out.println("L3计算消耗成本：" + ClimbStairCost.minCostClimbStairsL3(cost));
    }

    @Test
    public void minCostClimbStairsL2() {
        int[] cost = new int[]{1, 100, 1, 1, 100, 1};
        System.out.println("L2计算消耗成本：" + ClimbStairCost.minCostClimbStairsL2(cost));
    }

    @Test
    public void minCostClimbStairsL1() {
        int[] cost = new int[]{1, 2, 1, 1, 100, 1};
        System.out.println("L1计算消耗成本：" + ClimbStairCost.minCostClimbStairsL1(cost));
    }
}