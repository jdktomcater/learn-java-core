package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.hard;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 合并k个升序链表
 */
public class MergeKList {

    /**
     * 合并k个升序链表
     *
     * @param lists 链表数组
     * @return 合并完
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        return splitMerge(lists, 0, lists.length - 1);
    }

    /**
     * 分割合并
     *
     * @param lists 数组
     * @param start 开始索引
     * @param end   截至索引
     * @return 合并后链表
     */
    private static ListNode splitMerge(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = (end + start) >> 1;
        return mergeList(splitMerge(lists, start, mid), splitMerge(lists, mid + 1, end));
    }

    /**
     * 合并链表
     *
     * @param head1 链表1
     * @param head2 链表2
     * @return 合并后链表
     */
    private static ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        if (head1 != null) {
            node.next = head1;
        }
        if (head2 != null) {
            node.next = head2;
        }
        return dummy.next;
    }

}
