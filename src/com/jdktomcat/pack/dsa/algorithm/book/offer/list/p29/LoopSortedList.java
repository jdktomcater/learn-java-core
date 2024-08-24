package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p29;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.Node;

/**
 * 排序的循环链表
 */
public class LoopSortedList {


    /**
     * 插入节点
     *
     * @param head      链表头节点
     * @param insertVal 插入值
     * @return 头节点
     */
    public static Node insert(Node head, int insertVal) {
        Node node = new Node();
        node.value = insertVal;

        if (head == null) {
            head = node;
            head.next = head;
        } else if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }

    /**
     * 插入节点
     *
     * @param head 头节点
     * @param node 目标节点
     */
    private static void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = head;
        while (!(cur.value <= node.value && next.value >= node.value) && next != head) {
            cur = next;
            next = next.next;
            if (cur.value >= biggest.value) {
                biggest = cur;
            }
        }
        if (cur.value <= node.value && next.value >= node.value) {
            cur.next = node;
            node.next = next;
        } else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}
