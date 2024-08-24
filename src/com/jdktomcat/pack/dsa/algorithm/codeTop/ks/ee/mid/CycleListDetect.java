package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 循环链表
 */
public class CycleListDetect {

    /**
     * 环形链表
     *
     * @param head 链表头
     * @return 环形链表入口
     */
    public ListNode detectCycle(ListNode head) {
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
     * 判断链表是否有环
     *
     * @param head 链表头结点
     * @return true：有 false：无
     */
    public ListNode getCycleNode(ListNode head) {
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
