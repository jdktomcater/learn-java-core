package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p21;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 删除倒数第k个节点
 */
public class DeleteReverseKthNode {

    /**
     * 删除倒数第k个节点
     *
     * @param head 链表头结点
     * @param k    目标
     * @return 删除后的头结点
     */
    public static ListNode removeKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = head, back = dummy;
        for (int i = 0; i < k; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] target = {1,2,3,4,5,6};
        int k = 2;
        ListNode head = removeKthFromEnd(ListNode.build(target),k);
        System.out.println(Arrays.toString(ListNode.rebuild(head)));
    }
}
