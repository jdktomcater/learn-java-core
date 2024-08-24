package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 两数相加
 */
public class ListNumberAdd {

    /**
     * 两数相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 相加后链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = (l1 == null ? 0 : l1.value) + (l2 == null ? 0 : l2.value) + carry;
            carry = val >= 10 ? val / 10 : 0;
            val = val >= 10 ? val % 10 : val;
            cur.next = new ListNode(val);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
