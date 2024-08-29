package com.jdktomcat.pack.dsa.algorithm.book.offer.trie.p63;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReplaceWordsTest {

    @Test
    public void replaceWords() {
        String[] dict = new String[]{"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by battery";
        System.out.println(ReplaceWords.replaceWords(Arrays.asList(dict), sentence));
    }
}