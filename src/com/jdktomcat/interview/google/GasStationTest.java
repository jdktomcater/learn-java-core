package com.jdktomcat.interview.google;

import org.junit.Assert;
import org.junit.Test;

public class GasStationTest {

    @Test
    public void canCompleteCircuit() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 1, 2};
        int index = GasStation.canCompleteCircuit(a, b);
        Assert.assertEquals(3, index);
    }
}