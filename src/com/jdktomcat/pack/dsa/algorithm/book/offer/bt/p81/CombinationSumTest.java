package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p81;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationSumTest {

    @Test
    public void combinationSum() {
        int[] numbers = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> result = CombinationSum.combinationSum(numbers, target);
        for (List<Integer> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}