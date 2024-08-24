package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 相交链表
 */
public class IntersectList {

    /**
     * 计算链表长度
     *
     * @param head 链表头节点
     * @return 链表长度
     */
    private static int count(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    /**
     * 计算交接节点
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 交接节点
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 计算链表长度1
        int countA = count(headA);
        // 计算链表长度2
        int countB = count(headB);
        // 较长链表
        ListNode longer = countA > countB ? headA : headB;
        // 较短链表
        ListNode shorter = countA > countB ? headB : headA;
        // 长度差
        int step = Math.abs(countA - countB);
        // 截断长度，使两个链表长度相等
        for (int i = 0; i < step; i++) {
            longer = longer.next;
        }
        // 遍历查找两个链表相交节点
        while (longer != null && shorter != null) {
            // 相等的话，返回节点信息
            if (longer == shorter) {
                return shorter;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }

}
