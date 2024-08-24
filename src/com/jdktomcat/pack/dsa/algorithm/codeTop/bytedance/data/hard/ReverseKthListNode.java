package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.hard;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 翻转每k个节点链表
 */
public class ReverseKthListNode {

    /**
     * 翻转每k个节点
     *
     * @param head 链表
     * @param k    目标阈值
     * @return 翻转后链表头节点
     */
    public static ListNode reverseKth(ListNode head, int k) {
        return reverseKth(head, k, count(head));
    }

    /**
     * 翻转节点
     *
     * @param head  链表头
     * @param k     目标阈值
     * @param count 统计链表数目
     * @return 翻转节点头
     */
    private static ListNode reverseKth(ListNode head, int k, int count) {
        if (count >= k) {
            ListNode pre = null, node = head;
            int si = k;
            while (si-- >= 0) {
                ListNode next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            head.next = reverseKth(node, k, count - k);
            return pre;
        } else {
            return head;
        }
    }

    /**
     * 合计链表节点数量
     *
     * @param head 链表
     * @return 节点数量
     */
    private static int count(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
