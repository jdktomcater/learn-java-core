package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p22;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 链表中环的入口节点
 */
public class ListLoopEntryPoint {

    /**
     * 链表中环的入口节点
     *
     * @param head 链表头结点
     * @return 环入口节点
     */
    private static ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    /**
     * 查找环入口节点
     *
     * @param head 头结点
     * @return 入口节点
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
        ListNode node = head;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }
}
