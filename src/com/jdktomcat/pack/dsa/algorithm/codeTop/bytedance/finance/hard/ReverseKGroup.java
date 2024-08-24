package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.hard;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * K个一组翻转链表
 */
public class ReverseKGroup {

    /**
     * K个一组翻转链表
     *
     * @param head 链表头结点
     * @param k    阈值
     * @return 翻转后链表头
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroup(head,k,count(head));
    }

    /**
     * K个一组翻转链表
     *
     * @param head  链表头结点
     * @param k     阈值
     * @param count 链表长度
     * @return 翻转后链表头
     */
    public static ListNode reverseKGroup(ListNode head, int k, int count) {
        if (count >= k) {
            int index = k;
            ListNode pre = null, node = head;
            while (index-- > 0) {
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

    /**
     * 链表长度
     *
     * @param head 链表头
     * @return 链表长度
     */
    private static int count(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

}
