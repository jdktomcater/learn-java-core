package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.hard;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 合并K个链表
 */
public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = (end + start) >> 1;
        return mergeList(merge(lists, start, mid), merge(lists, mid + 1, end));
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0, null);
        ListNode node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null) {
            node.next = list2;
        }
        return dummy.next;
    }
}
