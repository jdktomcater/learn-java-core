package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p21;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 删除倒数第k个节点
 */
public class DeleteReverseKthNode {

    /**
     * 删除倒数第k个节点
     *
     * @param head 链表头结点
     * @param k    目标
     * @return 删除后的头结点
     */
    public static ListNode removeKthFromEnd(ListNode head, int k) {
        // 哨兵节点，简化操作
        ListNode dummy = new ListNode(0, head);
        // 双指针，front、back
        ListNode front = head, back = dummy;
        // 前指针先迁移k个节点
        for (int i = 0; i < k; i++) {
            front = front.next;
        }
        // 后双指针同时迁移，直到前指针迁移到链尾
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        // 如果不为空，则将目标节点从链上移除
        if (back.next != null) {
            back.next = back.next.next;
        }
        // 返回链表头节点
        return dummy.next;
    }
}
