package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 合并有序链表
 */
public class MergeSortedList {

    /**
     * 合并有序列表
     *
     * @param list1 列表1
     * @param list2 列表2
     * @return 合并后链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
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
