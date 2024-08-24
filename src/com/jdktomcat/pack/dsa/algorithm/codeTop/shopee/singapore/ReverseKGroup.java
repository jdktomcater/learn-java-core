package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 链表每k个节点反转
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return reverseKGroup(head, k, count);
    }

    private static ListNode reverseKGroup(ListNode head, int k, int count) {
        if (count >= k) {
            ListNode pre = null;
            ListNode node = head;
            int t = k;
            while (t-- > 0) {
                ListNode next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            head.next = reverseKGroup(node, k, count - k);
            return pre;
        } else {
            return head;
        }
    }
}
