package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p68;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void searchNormal() {
        int[] datas = {1, 2, 3, 4, 6, 7, 8, 9};
        int target = 3;
        int index = BinarySearch.search(datas, target);
        Assert.assertEquals(2, index);
    }

    @Test
    public void searchEdgeOnlyOne() {
        int[] datas = {1};
        int target = 1;
        int index = BinarySearch.search(datas, target);
        Assert.assertEquals(0, index);
    }

    @Test
    public void searchEdgeOnlyOneNotExist() {
        int[] datas = {1};
        int target = 0;
        int index = BinarySearch.search(datas, target);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void searchEdgeEmptyNotExist() {
        int[] datas = {};
        int target = 0;
        int index = BinarySearch.search(datas, target);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void searchEdgeNotExistBeforeHead() {
        int[] datas = {1, 2, 3, 4, 6, 7, 8, 9};
        int target = 0;
        int index = BinarySearch.search(datas, target);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void searchEdgeNotExistAfterTail() {
        int[] datas = {1, 2, 3, 4, 6, 7, 8, 9};
        int target = 10;
        int index = BinarySearch.search(datas, target);
        Assert.assertEquals(-1, index);
    }
}