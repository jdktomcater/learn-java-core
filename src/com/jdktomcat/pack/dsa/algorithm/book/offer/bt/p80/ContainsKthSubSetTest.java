package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p80;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ContainsKthSubSetTest {

    @Test
    public void containsKthSubSet() {
        List<List<Integer>> result = ContainsKthSubSet.containsKthSubSet(3, 2);
        for (List<Integer> subSet : result) {
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}