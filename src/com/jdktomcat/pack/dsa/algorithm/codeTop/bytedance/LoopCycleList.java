package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 环形链表
 */
public class LoopCycleList {
    /**
     * 判断链表是否有环
     *
     * @param head 链表头结点
     * @return true：有 false：无
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head.next;
        if (slow != null) {
            ListNode fast = slow.next;
            while (slow != null && fast != null && fast.next != null && slow != fast) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return !(fast == null || fast.next == null);
        }
        return false;
    }

    /**
     * 查找环形列表入口节点
     *
     * @param head 头节点
     * @return 环形列表入口节点
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
     * 判断链表是否有环
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


    public static void main(String[] args) {
        int[] numbers = {1, 2};
        ListNode head = ListNode.build(numbers);
        System.out.println(hasCycle(head));
    }
}
