package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 链表排序
 */
public class SortList {

    /**
     * 链表排序
     *
     * @param head 表头
     * @return 排序后链表头节点
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMidNode(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        if (head1 != null) {
            node.next = head1;
        }
        if (head2 != null) {
            node.next = head2;
        }
        return dummy.next;
    }

    private static ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(new int[]{3, 24, 5, 79, 2});
        ListNode node = sortList(head);
        System.out.println(Arrays.toString(ListNode.rebuild(node)));
    }
}
