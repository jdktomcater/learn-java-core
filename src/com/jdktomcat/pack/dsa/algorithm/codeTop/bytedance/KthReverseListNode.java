package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 链表中倒数第k个节点
 */
public class KthReverseListNode {

    /**
     * 链表中倒数第k个节点
     *
     * @param head 头节点
     * @param k    目标索引
     * @return 链表中倒数第k个节点
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k-- > 0 && fast != null) {
            fast = fast.next;
        }
        while (fast != null && slow != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
