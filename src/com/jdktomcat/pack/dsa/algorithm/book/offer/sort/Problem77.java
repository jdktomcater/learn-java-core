package com.jdktomcat.pack.dsa.algorithm.book.offer.sort;

/**
 * 链表排序
 */
public class Problem77 {

    /**
     * 链表节点
     */
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 分割
     *
     * @param head 头节点
     * @return 分割节点
     */
    public static ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;
    }

    /**
     * 链表合并
     *
     * @param head1 链表1
     * @param head2 链表2
     * @return 合并后头结点
     */
    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0, null);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head1 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

    /**
     * 链表排序
     *
     * @param head 头节点
     * @return 排序后头结点
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = split(head);
        return merge(head, head2);
    }


}
