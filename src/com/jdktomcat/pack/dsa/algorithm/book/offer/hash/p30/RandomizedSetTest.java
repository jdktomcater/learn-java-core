package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p30;

import org.junit.Assert;
import org.junit.Test;

public class RandomizedSetTest {

    @Test
    public void insert() {
        RandomizedSet set = new RandomizedSet();
        Assert.assertTrue(set.insert(1));
        Assert.assertTrue(set.insert(2));
        Assert.assertFalse(set.insert(2));
    }

    @Test
    public void remove() {
        RandomizedSet set = new RandomizedSet();
        Assert.assertTrue(set.insert(1));
        Assert.assertTrue(set.remove(1));
        Assert.assertFalse(set.remove(2));
    }

    @Test
    public void getRandom() {
        RandomizedSet set = new RandomizedSet();
        Assert.assertTrue(set.insert(1));
        Assert.assertEquals(1,set.getRandom());
    }
}