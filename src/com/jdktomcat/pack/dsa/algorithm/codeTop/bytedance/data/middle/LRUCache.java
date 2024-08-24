package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int size) {
        super(size, 0.75F, true);
        capacity = size;
    }

    public int get(Integer key) {
        return this.getOrDefault(key, -1);
    }

    public Integer put(Integer key, Integer value) {
        return super.put(key, value);
    }

    public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return this.size() > capacity;
    }

}
