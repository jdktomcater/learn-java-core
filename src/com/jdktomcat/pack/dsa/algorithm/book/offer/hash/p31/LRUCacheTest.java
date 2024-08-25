package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p31;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void get() {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        Assert.assertEquals(1, lruCache.get(1));
        Assert.assertEquals(2, lruCache.get(2));
        Assert.assertEquals(3, lruCache.get(3));
        Assert.assertEquals(4, lruCache.get(4));
    }

    @Test
    public void put() {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        Assert.assertEquals(-1, lruCache.get(1));
        Assert.assertEquals(2, lruCache.get(2));
        Assert.assertEquals(3, lruCache.get(3));
        Assert.assertEquals(4, lruCache.get(4));
        Assert.assertEquals(5, lruCache.get(5));
    }
}