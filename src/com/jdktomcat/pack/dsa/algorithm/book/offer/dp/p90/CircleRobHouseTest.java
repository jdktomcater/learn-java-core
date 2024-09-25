package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p90;

import org.junit.Test;

public class CircleRobHouseTest {

    @Test
    public void rob() {
        int[] numbers = new int[]{2, 3, 4, 5, 3};
        System.out.println("环形最大抢劫财产数：" + CircleRobHouse.rob(numbers));
    }
}