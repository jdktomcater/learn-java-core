package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p24;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 反转链表
 */
public class ReverseList {

    /**
     * 链表反转
     *
     * @param head 链表头节点
     * @return 反转后链表头节点
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
