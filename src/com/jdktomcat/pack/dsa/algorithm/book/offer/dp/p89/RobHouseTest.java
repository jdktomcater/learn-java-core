package com.jdktomcat.pack.dsa.algorithm.book.offer.dp.p89;

import org.junit.Test;

public class RobHouseTest {

    @Test
    public void rob() {
        int[] numbers = new int[]{2, 3, 4, 5, 3};
        System.out.println("L1最大抢劫财产数：" + RobHouse.rob(numbers));
    }

    @Test
    public void robL2() {
        int[] numbers = new int[]{2, 3, 4, 5, 3};
        System.out.println("L2最大抢劫财产数：" + RobHouse.robL2(numbers));
    }

    @Test
    public void robL3() {
        int[] numbers = new int[]{2, 3, 4, 5, 3};
        System.out.println("L3最大抢劫财产数：" + RobHouse.robL3(numbers));
    }
}