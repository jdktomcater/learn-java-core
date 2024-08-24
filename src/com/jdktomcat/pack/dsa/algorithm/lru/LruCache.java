package com.jdktomcat.pack.dsa.algorithm.lru;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类描述：lru缓存
 *
 * @author 汤旗
 * @date 2019-07-30 21:28
 */
public class LruCache {

    private Map<String, DoubleLinkedNode> cache = new ConcurrentHashMap<>();
    private int count;
    private int capacity;
    private DoubleLinkedNode head, tail;

    public LruCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        head.setPre(null);
        tail = new DoubleLinkedNode();
        tail.setNext(null);
        head.setNext(tail);
        tail.setPre(head);
    }

    public int get(String key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            // should raise exception here.
            return -1;
        }
        // move the accessed node to the head;
        this.moveToHead(node);
        return node.getValue();
    }


    public void set(String key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.setKey(key);
            newNode.setValue(value);
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if (count > capacity) {
                // pop the tail
                DoubleLinkedNode tail = this.popTail();
                this.cache.remove(tail.getKey());
                --count;
            }
        } else {
            // update the value.
            node.setValue(value);
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DoubleLinkedNode node) {
        node.setPre(head);
        node.setNext(head.getNext());
        head.getNext().setPre(node);
        head.setNext(node);
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode pre = node.getPre();
        DoubleLinkedNode post = node.getNext();
        pre.setNext(post);
        post.setPre(pre);
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DoubleLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * pop the current tail.
     */
    private DoubleLinkedNode popTail() {
        DoubleLinkedNode res = tail.getPre();
        this.removeNode(res);
        return res;
    }
}
