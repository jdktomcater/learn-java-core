package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p68;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void search() {
        int[] datas = {1,2,3,4,6,7,8,9};
        int target = 0;
        int index = BinarySearch.search(datas, target);
        Assert.assertEquals(-1, index);
    }
}