package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p82;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ContainSameEleCombinationSumTest {

    @Test
    public void combinationSum() {
        int[] numbers = new int[]{2, 2, 2, 4, 3, 3};
        int target = 8;
        List<List<Integer>> result = ContainSameEleCombinationSum.combinationSum(numbers, target);
        for (List<Integer> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}