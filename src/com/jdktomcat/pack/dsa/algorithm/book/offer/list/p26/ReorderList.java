package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p26;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 重排列表
 */
public class ReorderList {

    /**
     * 重排序列表
     *
     * @param head 列表头节点
     */
    public static void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode temp = slow.next;
        slow.next = null;
        link(head, ListNode.reverseList(temp), dummy);
    }

    /**
     * 节点连接
     *
     * @param node1 节点1
     * @param node2 节点2
     * @param head  头节点
     */
    private static void link(ListNode node1, ListNode node2, ListNode head) {
        ListNode prev = head;
        while (node1 != null && node2 != null) {
            ListNode temp = node1.next;

            prev.next = node1;
            node1.next = node2;
            prev = node2;

            node1 = temp;
            node2 = node2.next;
        }
        if (node1 != null) {
            prev.next = node1;
        }
    }
}
