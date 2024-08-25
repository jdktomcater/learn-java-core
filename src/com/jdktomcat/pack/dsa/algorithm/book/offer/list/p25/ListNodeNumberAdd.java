package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p25;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 链表中的数字相加
 */
public class ListNodeNumberAdd {

    /**
     * 链表中的数字相加
     *
     * @param head1 链表头节点1
     * @param head2 链表头节点2
     * @return 相加后链表头节点
     */
    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        head1 = ListNode.reverseList(head1);
        head2 = ListNode.reverseList(head2);
        ListNode reverseHead = addReversed(head1, head2);
        return ListNode.reverseList(reverseHead);
    }

    /**
     * 链表中的数字相加
     *
     * @param head1 链表头节点1
     * @param head2 链表头节点2
     * @return 相加后链表头节点
     */
    private static ListNode addReversed(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.value) + (head2 == null ? 0 : head2.value) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            sumNode.next = new ListNode(sum);
            sumNode = sumNode.next;
            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        if (carry > 0) {
            sumNode.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
