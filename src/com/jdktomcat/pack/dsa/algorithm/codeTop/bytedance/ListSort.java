package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import com.jdktomcat.pack.dsa.algorithm.book.offer.util.SwapUtil;

import java.util.Arrays;

/**
 * 排序链表
 */
public class ListSort {

    /**
     * 排序链表
     *
     * @param head 头节点
     * @return 排序头节点
     */
    public static ListNode sortList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode subNode = node.next;
            while (subNode != null) {
                if (subNode.value < node.value) {
                    SwapUtil.swap(subNode, node);
                }
                subNode = subNode.next;
            }
            node = node.next;
        }
        return head;
    }

    /**
     * 归并排序
     *
     * @param head 链表头结点
     * @return 排序后链表头节点
     */
    public static ListNode sortListL0(ListNode head) {
        return sortList(head, null);
    }

    /**
     * 归并排序
     *
     * @param head 头节点
     * @param tail 尾节点
     * @return 合并后链表节点
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
        ListNode midNode = midList(head, tail);
        // 前半部分链表
        ListNode preList = sortList(head, midNode);
        // 后半部分链表
        ListNode nextList = sortList(midNode, tail);
        // 合并链表
        return merge(preList, nextList);
    }

    /**
     * 合并两个链表
     *
     * @param head1 链表1头
     * @param head2 链表2头
     * @return 合并后链表2
     */
    public static ListNode merge(ListNode head1, ListNode head2) {
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
     * @param head 链表头结点
     * @param tail 链表尾结点
     * @return 中间节点
     */
    private static ListNode midList(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] numbers = {4, 2, 1, 3};
        ListNode head = sortList(ListNode.build(numbers));
        System.out.println(Arrays.toString(ListNode.rebuild(head)));
    }
}
