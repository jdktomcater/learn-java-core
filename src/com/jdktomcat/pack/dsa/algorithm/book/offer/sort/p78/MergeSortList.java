package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p78;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p77.ListSort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并排序列表
 */
public class MergeSortList {

    /**
     * 合并多个链表(最小堆)
     *
     * @param lists 链表
     * @return 合并后链表头节点
     */
    public static ListNode mergeKListsMinHeap(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.value));
        for (ListNode node : lists) {
            ListNode curNode = node;
            while (curNode != null) {
                minHeap.offer(curNode);
                curNode = curNode.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode least = minHeap.poll();
            cur.next = least;
            cur = least;
            least.next = null;
        }
        return dummy.next;
    }

    /**
     * 合并多个链表(合并排序)
     *
     * @param lists 链表
     * @return 合并后链表头节点
     */
    public static ListNode mergeKListsMerge(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    /**
     * 合并多个链表(合并排序)
     *
     * @param lists 链表
     * @param start 起始索引
     * @param end   截止索引
     * @return 合并后链表头节点
     */
    private static ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start + 1 == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode head1 = mergeLists(lists, start, mid);
        ListNode head2 = mergeLists(lists, mid + 1, end);
        return ListSort.merge(head1, head2);
    }

}
