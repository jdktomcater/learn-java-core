package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p31;

import com.jdktomcat.pack.util.jdk8.LinkedHashMap;

import java.util.Map;

/**
 * 实现
 */
public class ALRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int cacheSize;

    public ALRUCache(int capacity){
        super((int) Math.ceil(capacity / 0.75f), 0.75f, true);
        this.cacheSize = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > cacheSize;
    }
}
