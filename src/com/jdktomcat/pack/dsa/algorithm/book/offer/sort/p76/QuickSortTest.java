package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p76;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void quickSortNormal() {
        int[] numbers = new int[]{23, 1, 56, 34, 234, 6, 13, 24};
        QuickSort.quickSort(numbers, 0, numbers.length - 1);
        int[] targets = new int[]{1, 6, 13, 23, 24, 34, 56, 234};
        Assert.assertArrayEquals(targets, numbers);
    }

    @Test
    public void quickSortNormalSameElement() {
        int[] numbers = new int[]{23, 1, 56, 34, 234, 6, 13, 24, 1, 1};
        QuickSort.quickSort(numbers, 0, numbers.length - 1);
        int[] targets = new int[]{1, 1, 1, 6, 13, 23, 24, 34, 56, 234};
        Assert.assertArrayEquals(targets, numbers);
    }

    @Test
    public void quickSortEdgeEmpty() {
        int[] numbers = new int[]{};
        QuickSort.quickSort(numbers, 0, numbers.length - 1);
        int[] targets = new int[]{};
        Assert.assertArrayEquals(targets, numbers);
    }

    @Test
    public void quickSortEdgeOnlyOne() {
        int[] numbers = new int[]{1};
        QuickSort.quickSort(numbers, 0, 0);
        int[] targets = new int[]{1};
        Assert.assertArrayEquals(targets, numbers);
    }
}