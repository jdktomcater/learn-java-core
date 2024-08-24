package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 奇偶链表相关问题
 * <p>
 * 链表，奇数位置按序增长，偶数位置按序递减，如何能实现链表从小到大排序？（2020.10 字节跳动-后端）[2]
 * 奇偶生序倒序链表的重新排序组合，例如：18365472（2020.08 字节跳动-后端）[3]
 * 1->4->3->2->5 给定一个链表奇数部分递增，偶数部分递减，要求在O(n)时间复杂度内将链表变成递增，5分钟左右（2020.07 字节跳动-测试开发）[4]
 * 奇数位升序偶数位降序的链表要求时间O(n)空间O(1)的排序？(2020.07 字节跳动-后端)[5]
 */
public class OddEvenListIssue {

    /**
     * 链表，奇数位置按序增长，偶数位置按序递减，如何能实现链表从小到大排序？
     *
     * @param head 链表头
     */
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            prev.next = next;
            prev = cur;
            cur = cur.next;
        }
        evenHead = revert(evenHead);
        return merge(oddHead, evenHead);
    }

    /**
     * 反转链表
     *
     * @param head 表头
     * @return 反转后表头
     */
    private static ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 链表合并
     *
     * @param head1 链表1
     * @param head2 链表2
     * @return 合并后链表表头
     */
    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 8, 3, 6, 5, 4, 7, 2};
        ListNode head = ListNode.build(numbers);
        System.out.println(Arrays.toString(ListNode.rebuild(sortList(head))));
    }
}
