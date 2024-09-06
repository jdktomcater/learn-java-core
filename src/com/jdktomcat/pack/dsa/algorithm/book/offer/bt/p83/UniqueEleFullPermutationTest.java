package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p83;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UniqueEleFullPermutationTest {

    @Test
    public void permute() {
        int[] numbers = new int[]{1, 2, 3};
        List<List<Integer>> result = UniqueEleFullPermutation.permute(numbers);
        for (List<Integer> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}