package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 重排链表
 */
public class ReorderList {

    /**
     * 重排链表
     *
     * @param head 表头
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode midNode = getMidNode(head);
        ListNode secondHalfHead = reverse(midNode);
        ListNode firstHalfHead = head;
        // 链表合并
        while (firstHalfHead != null && secondHalfHead != null) {
            ListNode firstNextNode = firstHalfHead.next;
            ListNode secondNextNode = secondHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            secondHalfHead.next = firstNextNode;
            firstHalfHead = firstNextNode;
            secondHalfHead = secondNextNode;
        }
    }
    private static ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        return next;
    }

    private static ListNode reverse(ListNode head) {
        // 链表反转
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return prev;
    }
}
