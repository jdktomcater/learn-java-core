package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p27;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 回文链表
 */
public class PalindromeList {


    /**
     * 判断链表是否是回文链表
     *
     * @param head 链表头节点
     * @return true:是 false:否
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        if (fast.next != null) {
            secondHalf = slow.next.next;
        }
        slow.next = null;
        return equals(secondHalf, ListNode.reverseList(head));
    }

    /**
     * 比较
     *
     * @param head1 头节点1
     * @param head2 头节点2
     * @return true：是 false：否
     */
    private static boolean equals(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.value != head2.value) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

}
