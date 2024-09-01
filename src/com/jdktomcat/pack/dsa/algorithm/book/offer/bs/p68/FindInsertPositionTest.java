package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p68;

import org.junit.Test;

public class FindInsertPositionTest {

    @Test
    public void searchInsert() {
        int[] numbers = new int[]{1,3,6,8};
        System.out.println(FindInsertPosition.searchInsert(numbers,3));
        System.out.println(FindInsertPosition.searchInsert(numbers,5));
        System.out.println(FindInsertPosition.searchInsert(numbers,15));
    }
}