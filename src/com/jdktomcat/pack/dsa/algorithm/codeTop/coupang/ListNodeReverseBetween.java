package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 反转链表 II
 */
public class ListNodeReverseBetween {

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     * @param head  链表表头
     * @param left  左索引
     * @param right 右索引
     * @return 反转后链表头
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (--left != 0) {
            pre = cur;
            cur = cur.next;
        }
        int step = right - left;
        ListNode preNode = pre;
        ListNode nextNode = preNode.next;
        pre = null;
        while (cur != null && step >= 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            step--;
        }
        if (nextNode != null) {
            nextNode.next = cur;
        }
        preNode.next = pre;
        return dummy.next;
    }

}
