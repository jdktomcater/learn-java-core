package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class ListIntersectionNode {

    /**
     * 两个链表的第一个公共节点
     *
     * @param headA 链表1
     * @param headB 链表2
     * @return 公共节点
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = count(headA), countB = count(headB);
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            if (countA > countB) {
                headA = headA.next;
                countA--;
            } else if (countA == countB) {
                headA = headA.next;
                headB = headB.next;
                countA--;
                countB--;
            } else {
                headB = headB.next;
                countB--;
            }
        }
        return null;
    }

    /**
     * 链表长度
     *
     * @param head 链表
     * @return 长度
     */
    private static int count(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}
