package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 每k个节点反转
 */
public class ReverseKthListNode {

    /**
     * 每k个节点链表反转
     *
     * @param head 链表头结点
     * @param k    阈值
     * @return 反转后链表头结点
     */
    public static ListNode kthReverse(ListNode head, int k) {
        ListNode tail = getKListNode(head, k);
        if (tail.next != null) {
            tail.next = kthReverse(tail.next, k);
        }
        reverse(head, tail);
        return tail;
    }

    /**
     * 获取链表第k个节点
     *
     * @param head 头结点
     * @param k    阈值
     * @return 获取链表k个节点
     */
    private static ListNode getKListNode(ListNode head, int k) {
        ListNode cur = head;
        while (cur.next != null && --k > 0) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 链表反转
     *
     * @param head 头结点
     * @param tail 尾节点
     * @return 头结点
     */
    private static void reverse(ListNode head, ListNode tail) {
        ListNode node = head;
        ListNode pre = tail.next;
        while (node != tail) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        tail.next = pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        int k = 3;
        System.out.println(Arrays.toString(ListNode.rebuild(kthReverse(head, k))));
    }

}
