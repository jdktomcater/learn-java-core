package com.jdktomcat.pack.dsa.algorithm.codeTop.ks;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 反转链表 II
 */
public class ReverseListBetween {

    /**
     * 链表翻转
     *
     * @param head  链表头节点
     * @param left  左索引
     * @param right 右索引
     * @return 翻转
     */
    public static ListNode reverseBetweenL0(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = null;
        ListNode node = dummy.next;
        int step = right - left;
        while (node != null && --left != 0) {
            prev = node;
            node = node.next;
        }
        ListNode preNode = (prev == null ? dummy : prev);
        ListNode nextNode = preNode.next;
        prev = null;
        while (node != null && step-- >= 0) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        if (nextNode != null) {
            nextNode.next = node;
        }
        preNode.next = prev;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        ListNode head = ListNode.build(numbers);
        int left = 2, right = 4;
        ListNode newHead = reverseBetweenL0(head, left, right);
        System.out.println(Arrays.toString(ListNode.rebuild(newHead)));
    }
}
