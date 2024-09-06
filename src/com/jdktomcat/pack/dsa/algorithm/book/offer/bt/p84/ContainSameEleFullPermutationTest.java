package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p84;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ContainSameEleFullPermutationTest {

    @Test
    public void permute() {
        int[] numbers = new int[]{1, 1, 2};
        List<List<Integer>> result = ContainSameEleFullPermutation.permute(numbers);
        for (List<Integer> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}