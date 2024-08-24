package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 合并K个升序链表
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeLists {

    /**
     * 链表合并(分治)
     *
     * @param lists 链表数组
     * @return 合并后链表
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 链表合并
     *
     * @param lists 链表数组
     * @param left  左索引
     * @param right 右索引
     * @return 链表合并后头结点
     */
    private static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (right + left) >> 1;
        return mergeList(merge(lists, left, mid), merge(lists, mid + 1, right));

    }

    /**
     * @param list1
     * @param list2
     * @return
     */
    private static ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1 != null && node2 != null) {
            if (node1.value < node2.value) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return dummy.next;
    }

}
