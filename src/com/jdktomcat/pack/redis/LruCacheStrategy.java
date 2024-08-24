package com.jdktomcat.pack.redis;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCacheStrategy<K, V> extends LinkedHashMap<K, V> {

    private int cacheSize;

    public LruCacheStrategy(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75f), 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return cacheSize <= this.size();
    }
}
