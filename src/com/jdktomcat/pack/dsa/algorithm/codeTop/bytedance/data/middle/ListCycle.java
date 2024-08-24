package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 环形链表
 */
public class ListCycle {

    /**
     * 环形链表入口节点
     *
     * @param head 链表头
     * @return 入口节点
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode inCycleNode = getCycleNode(head);
        if (inCycleNode == null) {
            return null;
        }
        ListNode node = head;
        while (node != inCycleNode) {
            node = node.next;
            inCycleNode = inCycleNode.next;
        }
        return node;
    }

    /**
     * 判断链表是否有环（快慢节点）
     *
     * @param head 链表头结点
     * @return true：有 false：无
     */
    public static ListNode getCycleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head.next;
        if (slow != null) {
            ListNode fast = slow.next;
            while (slow != null && fast != null && fast.next != null && slow != fast) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast == null || fast.next == null) {
                return null;
            } else {
                return slow;
            }
        }
        return null;
    }
}
