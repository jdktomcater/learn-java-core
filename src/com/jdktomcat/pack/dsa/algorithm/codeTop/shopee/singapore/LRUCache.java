package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存
 */
public class LRUCache extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    public  boolean removeEldestEntry(Map.Entry<Integer,Integer> entry){
        return super.size() > capacity;
    }

}
