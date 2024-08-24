package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 列表反转：
 * <p>
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseListII {

    /**
     * 列表反转:
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     *
     * @param head  链表头结点
     * @param left  左下标
     * @param right 右下标
     * @return 列表反转后头结点
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 判断左右指针是否相等，如果相等的话，直接返回
        if (left == right) {
            return head;
        }
        // 哨兵节点
        ListNode dummy = new ListNode(0);
        // 指向头结点
        dummy.next = head;
        // 标记前节点
        ListNode prev = null;
        // 设置游标节点
        ListNode node = dummy.next;
        // 设置处理长度
        int step = right - left;
        // 寻找处理开始节点
        while (node != null && --left != 0) {
            prev = node;
            node = node.next;
        }
        // 记录处理开始节点的前节点
        ListNode preNode = (prev == null ? dummy : prev);
        // 记录处理开始节点的后节点
        ListNode nextNode = preNode.next;
        // 先置空
        prev = null;
        // 目标链表节点反转
        while (node != null && step >= 0) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            step--;
        }
        // 链接尾部
        if (nextNode != null) {
            nextNode.next = node;
        }
        // 链接头部
        preNode.next = prev;
        // 返回链表头部
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] numbers = { 5};
        int left = 1;
        int right = 1;
        ListNode head = reverseBetween(ListNode.build(numbers), left, right);
        System.out.println(Arrays.toString(ListNode.rebuild(head)));
    }
}
