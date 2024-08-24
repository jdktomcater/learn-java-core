package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 链表反转
 */
public class ReverseList {
    /**
     * 链表反转
     *
     * @param head  链表头节点
     * @param left  左索引
     * @param right 右索引
     * @return 反转后链表
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode node = dummy.next;
        int step = right - left;
        while (node != null && --left != 0) {
            prev = node;
            node = node.next;
        }
        ListNode preNode = prev;
        ListNode nextNode = preNode.next;
        prev = null;
        while (node != null && step >= 0) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            step--;
        }
        if (nextNode != null) {
            nextNode.next = node;
        }
        preNode.next = prev;
        return dummy.next;
    }

}
