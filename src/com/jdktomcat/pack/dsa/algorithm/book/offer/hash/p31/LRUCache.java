package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p31;

import java.util.HashMap;
import java.util.Map;

/**
 * 最近最少使用缓存
 */
public class LRUCache {

    /**
     * 双向链表节点
     */
    public static class ListNode {
        public int key;

        public int val;

        public ListNode next;

        public ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final ListNode head;

    private final ListNode tail;

    private final Map<Integer, ListNode> map;

    private final int capacity;

    public LRUCache(int cap) {
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = cap;
    }

    private void moveToTail(ListNode node, int val) {
        deleteNode(node);
        node.val = val;
        insertToTail(node);
    }

    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToTail(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node, node.val);
        return node.val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            moveToTail(map.get(key), val);
        } else {
            if (map.size() == capacity) {
                ListNode toBeDeleted = head.next;
                deleteNode(toBeDeleted);
                map.remove(toBeDeleted.key);
            }
            ListNode node = new ListNode(key, val);
            insertToTail(node);
            map.put(key, node);
        }
    }
}
