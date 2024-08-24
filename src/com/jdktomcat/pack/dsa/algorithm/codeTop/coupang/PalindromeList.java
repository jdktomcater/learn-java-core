package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 回文链表
 */
public class PalindromeList {

    /**
     * 回文链表
     *
     * @param head 链表头结点
     * @return true：是 false：否
     */
    public static boolean isPalindrome(ListNode head) {
        StringBuilder positive = new StringBuilder();
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            positive.append(node.value);
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        StringBuilder reverse = new StringBuilder();
        node = prev;
        while (node != null) {
            reverse.append(node.value);
            node = node.next;
        }
        return positive.toString().equals(reverse.toString());
    }

}
