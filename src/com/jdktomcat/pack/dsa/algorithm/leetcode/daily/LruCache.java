package com.jdktomcat.pack.dsa.algorithm.leetcode.daily;

import java.util.LinkedHashMap;

public class LruCache<K,V> extends LinkedHashMap<K,V> {


    /**
     * Constructs an empty <tt>LinkedHashMap</tt> instance with the
     * specified initial capacity, load factor and ordering mode.
     *
     * @param initialCapacity the initial capacity
     * @param loadFactor      the load factor
     * @throws IllegalArgumentException if the initial capacity is negative
     *                                  or the load factor is nonpositive
     */
    public LruCache(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
    }


}
