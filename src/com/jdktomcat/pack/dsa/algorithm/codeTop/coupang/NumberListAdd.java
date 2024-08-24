package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 链表数字相加
 */
public class NumberListAdd {

    /**
     * 链表数字相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 相加后结果链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode node = dummy;
        int carry = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int value = (node1 == null ? 0 : node1.value) + (node2 == null ? 0 : node2.value) + carry;
            carry = (value >= 10 ? 1 : 0);
            value = (value >= 10 ? value % 10 : value);
            node.next = new ListNode(value);
            node = node.next;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        return dummy.next;
    }

}
