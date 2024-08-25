package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p33;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnamorphicWordsGroupTest {

    @Test
    public void groupAnagrams() {
        String[] args = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = AnamorphicWordsGroup.groupAnagrams(args);
        Assert.assertEquals(3, resultList.size());
    }

    @Test
    public void groupAnagramsSort() {
        String[] args = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = AnamorphicWordsGroup.groupAnagramsSort(args);
        Assert.assertEquals(3, resultList.size());
    }
}