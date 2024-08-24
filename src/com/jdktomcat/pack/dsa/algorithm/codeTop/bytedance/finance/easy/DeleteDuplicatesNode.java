package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 删除排序链表中的重复元素
 */
public class DeleteDuplicatesNode {

    /**
     * 删除排序链表中的重复元素
     *
     * @param head 链表头部元素
     * @return 删除排序链表中的重复元素
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            while (next != null && next.value == node.value) {
                next = next.next;
            }
            node.next = next;
            node = next;
        }
        return head;
    }

}

