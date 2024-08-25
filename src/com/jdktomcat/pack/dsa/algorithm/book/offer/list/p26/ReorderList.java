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
        // 哨兵节点
        ListNode dummy = new ListNode(0, head);
        // 双指针：快慢指针
        ListNode fast = dummy, slow = dummy;
        // 查找中间节点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        // 中间节点
        ListNode temp = slow.next;
        // 截断链表
        slow.next = null;
        // 重连链表
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
