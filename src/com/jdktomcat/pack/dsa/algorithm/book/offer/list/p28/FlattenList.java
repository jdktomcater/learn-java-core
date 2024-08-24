package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p28;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.Node;

/**
 * 展平多级链表
 */
public class FlattenList {

    /**
     * 展平多级链表
     *
     * @param head 头
     * @return
     */
    public static Node fatten(Node head) {
        flattenGetTail(head);
        return head;
    }

    /**
     * 展平并获取尾节点
     *
     * @param head 头节点
     * @return 尾节点
     */
    private static Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            Node next = node.next;
            if (node.child != null) {
                Node child = node.child;
                Node childTail = flattenGetTail(child);
                node.child = null;
                node.next = child;
                child.prev = node;
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
                tail = childTail;
            } else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }
}
