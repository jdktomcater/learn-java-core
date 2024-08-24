package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 缓存
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int cacheSize;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        cacheSize = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > cacheSize;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));   // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(1));
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);
    }
}
