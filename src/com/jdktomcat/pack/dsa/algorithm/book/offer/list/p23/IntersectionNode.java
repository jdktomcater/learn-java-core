package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p23;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 两个链表的第一个重合节点
 */
public class IntersectionNode {

    /**
     * 找出两个链表的第一个重合节点
     *
     * @param head1 链表1
     * @param head2 链表2
     * @return 第一个重合节点
     */
    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int count1 = ListNode.countList(head1);
        int count2 = ListNode.countList(head2);
        int delta = Math.abs(count1 - count2);
        ListNode longer = count1 > count2 ? head1 : head2;
        ListNode shorter = count1 > count2 ? head2 : head1;
        ListNode node1 = longer;
        for (int i = 0; i < delta; i++) {
            node1 = node1.next;
        }
        ListNode node2 = shorter;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}
