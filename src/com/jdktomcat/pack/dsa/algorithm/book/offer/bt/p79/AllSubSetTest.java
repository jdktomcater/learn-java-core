package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p79;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AllSubSetTest {

    @Test
    public void subSet() {
        int[] numbers = new int[]{1, 2, 3, 20};
        List<List<Integer>> result = AllSubSet.subSet(numbers);
        for (List<Integer> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}