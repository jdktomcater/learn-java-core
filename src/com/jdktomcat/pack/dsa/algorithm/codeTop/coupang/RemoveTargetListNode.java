package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 移除链表元素
 */
public class RemoveTargetListNode {

    /**
     * 移除链表元素
     *
     * @param head 链表头结点
     * @param val  目标值
     * @return 新表头
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.value == val) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return dummy.next;
    }

}
