package com.jdktomcat.pack.dsa.algorithm.company.vip;

import java.util.Arrays;


/**
 * 线性探测解决哈希冲突map实现类
 */
public class LinearDetectionMap {

    static class Entry {
        private final long key;

        private long value;

        public void setValue(long value) {
            this.value = value;
        }

        public Entry(long key, long value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 初始化大小
     */
    private int capacity;

    /**
     * 存储
     */
    private Entry[] entrys;

    /**
     * 元素个数
     */
    private int size;

    /**
     * Constructor initializes buckets array, capacity, and creates dummy object
     * for AVAILABLE
     *
     * @param capacity the desired size of the hash map
     */
    public LinearDetectionMap(int capacity) {
        this.entrys = new Entry[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 计算哈希值
     *
     * @param key 键
     * @return 哈希值
     */
    public int hash(long key) {
        return (int) (key % capacity);
    }

    /**
     * 插入数据
     *
     * @param key   键
     * @param value 值
     */
    public void put(long key, long value) {
        int hash = hash(key);
        if (isFull()) {
            resize();
        }
        for (int i = 0; i < capacity; i++) {
            if (entrys[hash] == null || entrys[hash].key == key) {
                if (entrys[hash] == null) {
                    entrys[hash] = new Entry(key, value);
                    size++;
                } else {
                    entrys[hash].setValue(value);
                }
                return;
            }
            if (hash + 1 < capacity) {
                hash++;
            } else {
                hash = 0;
            }
        }
    }

    /**
     * 查找键值
     *
     * @param key 键
     * @return 值
     */
    public long get(long key) {
        int hash = hash(key);
        for (int i = 0; i < capacity; i++) {
            if (entrys[hash] != null && entrys[hash].key == key) {
                return entrys[hash].value;
            }
            if (hash + 1 < capacity) {
                hash++;
            } else {
                hash = 0;
            }
        }
        return -1L;
    }

    /**
     * 扩容
     */
    public void resize() {
        entrys = Arrays.copyOf(entrys, capacity * 2);
        capacity *= 2;
    }

    /**
     * 检查容器是否已满
     *
     * @return true：是 false：否
     */
    public boolean isFull() {
        boolean response = true;
        for (int i = 0; i < capacity; i++) {
            if (entrys[i] == null) {
                response = false;
                break;
            }
        }
        return response;
    }

    /**
     * 获取元素数量
     *
     * @return 元素数量
     */
    public int size() {
        return this.size;
    }


    public static void main(String[] args) {
        LinearDetectionMap dataMap = new LinearDetectionMap(10);
        for (long i = 0; i < 100L; i++) {
            dataMap.put(i, i);
            System.out.println("key:" + i + " value:" + dataMap.get(i));
        }
    }
}


