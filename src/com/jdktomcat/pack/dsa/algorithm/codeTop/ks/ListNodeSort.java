package com.jdktomcat.pack.dsa.algorithm.codeTop.ks;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 链表排序
 */
public class ListNodeSort {

    /**
     * 链表排序
     *
     * @param head 链表头结点
     * @return 排序后头节点
     */
    public static ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    /**
     * 链表排序
     *
     * @param head 链表头结点
     * @param tail 链表尾节点
     * @return 排序后头节点
     */
    public static ListNode sortList(ListNode head, ListNode tail) {
        // 判空
        if (head == null) {
            return null;
        }
        // 判节点是否只有一个
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 取中间节点
        ListNode midNode = midNode(head, tail);
        // 合并链表
        return merge(sortList(head, midNode), sortList(midNode, tail));
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy, node1 = head1, node2 = head2;
        while (node1 != null && node2 != null) {
            if (node1.value <= node2.value) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        } else if (node2 != null) {
            node.next = node2;
        }
        return dummy.next;
    }


    /**
     * 获取链表中间节点
     *
     * @param head 链表头节点
     * @return 中间节点
     */
    public static ListNode midNode(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
