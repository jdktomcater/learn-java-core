package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {

    /**
     * 删除链表的倒数第 N 个结点
     *
     * @param head 头结点
     * @param n    阈值
     * @return 头结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy.next, fast = dummy.next, prev = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return dummy.next;
    }
}
