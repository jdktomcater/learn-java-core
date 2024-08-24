package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 反转链表
 */
public class ReverseList {

    /**
     * 链表翻转
     *
     * @param head 链表头
     * @return 翻转后头结点
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
