package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p91;

import org.junit.Assert;
import org.junit.Test;

public class BrushHouseTest {

    @Test
    public void miniCost() {
        int[][] costs = {{17, 2, 16}, {15, 14, 5}, {13, 3, 1}};
        int minCost =  BrushHouse.miniCost(costs);
        Assert.assertEquals(10, minCost);
    }
}