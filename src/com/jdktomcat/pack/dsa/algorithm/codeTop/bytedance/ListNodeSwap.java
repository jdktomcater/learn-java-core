package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 两两交换链表中的节点
 */
public class ListNodeSwap {

    /**
     * 两两交换链表中的节点
     *
     * @param head 链表头结点
     * @return 新链表头结点
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            ListNode nextNode = cur.next;
            if (nextNode != null) {
                ListNode next = nextNode.next;
                prev.next = nextNode;
                nextNode.next = cur;
                cur.next = next;
                prev = cur;
                cur = next;
            } else {
                cur = null;
            }
        }
        return dummy.next;
    }
}
