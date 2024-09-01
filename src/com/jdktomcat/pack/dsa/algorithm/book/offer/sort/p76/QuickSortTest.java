package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p76;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void quickSort() {
        int[] numbers = new int[]{23, 1, 56, 34, 234, 6, 13, 24};
        QuickSort.quickSort(numbers, 0, numbers.length - 1);
        int[] targets = new int[]{1, 6, 13, 23, 24, 34, 56, 234};
        Assert.assertArrayEquals(targets, numbers);
    }
}