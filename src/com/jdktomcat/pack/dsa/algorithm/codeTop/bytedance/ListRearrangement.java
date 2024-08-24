package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 链表重排
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ListRearrangement {

    /**
     * 链表重排
     *
     * @param head 链表头结点
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfHead = slow.next;
        // 链表反转
        ListNode prev = null;
        ListNode node = secondHalfHead;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        secondHalfHead = prev;
        slow.next = null;
        ListNode firstHalfHead = head;
        // 链表合并
        while (firstHalfHead != null && secondHalfHead != null) {
            ListNode firstNextNode = firstHalfHead.next;
            ListNode secondNextNode = secondHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            secondHalfHead.next = firstNextNode;
            firstHalfHead = firstNextNode;
            secondHalfHead = secondNextNode;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        ListNode head = ListNode.build(numbers);
        reorderList(head);
        System.out.println(Arrays.toString(ListNode.rebuild(head)));
    }

}
