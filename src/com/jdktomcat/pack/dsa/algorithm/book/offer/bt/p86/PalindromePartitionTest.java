package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p86;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PalindromePartitionTest {

    @Test
    public void partition() {
        String target = "google";
        List<List<String>> result = PalindromePartition.partition(target);
        for (List<String> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}