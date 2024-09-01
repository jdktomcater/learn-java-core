package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p70;

import org.junit.Assert;
import org.junit.Test;

public class SortedArrayOccurOnceTest {

    @Test
    public void singleNonDuplicate() {
        int[] numbers = new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5};
        Assert.assertEquals(3, SortedArrayOccurOnce.singleNonDuplicate(numbers));
    }
}