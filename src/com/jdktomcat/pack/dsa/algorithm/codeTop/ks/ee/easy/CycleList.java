package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

public class CycleList {

    /**
     * 判断链表是否有环
     *
     * @param head 链表头节点
     * @return true：是 false：否
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head.next;
        if (slow != null) {
            ListNode fast = slow.next;
            while (slow != null && fast != null && fast.next != null && slow != fast) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return !(fast == null || fast.next == null);
        }
        return false;
    }

}
