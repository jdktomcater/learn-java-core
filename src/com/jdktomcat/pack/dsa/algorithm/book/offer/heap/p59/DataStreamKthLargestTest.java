package com.jdktomcat.pack.dsa.algorithm.book.offer.heap.p59;

import org.junit.Assert;
import org.junit.Test;

public class DataStreamKthLargestTest {

    @Test
    public void getKthLargest() {
        DataStreamKthLargest dataStreamKthLargest = new DataStreamKthLargest(5, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assert.assertEquals(5, dataStreamKthLargest.getKthLargest());
    }
}