package com.jdktomcat.pack.dsa.algorithm.company.cobo;

import java.util.Arrays;

public class RevelKthNode {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    /**
     * 构建链表
     *
     * @param target 目标数组
     * @return 链表头
     */
    public static ListNode buildList(int[] target) {
        if (target == null || target.length == 0) {
            return null;
        }
        ListNode head = new ListNode(target[0], null);
        ListNode node = head;
        for (int index = 1; index < target.length; index++) {
            ListNode curNode = new ListNode(target[index], null);
            node.next = curNode;
            node = curNode;
        }
        return head;
    }

    /**
     * 逆转化链表
     *
     * @param head 头结点
     * @return 数组
     */
    public static int[] rebuildList(ListNode head) {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        int[] target = new int[size];
        node = head;
        size = 0;
        while (node != null) {
            target[size++] = node.val;
            node = node.next;
        }
        return target;
    }

    /**
     * 查询倒数第k个元素
     *
     * @param head 链表头
     * @param k    倒数k
     * @return 节点信息
     */
    public static ListNode kthNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 变形转化
     *
     * @param head 头结点
     */
    public static void transfer(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            ListNode preNode = node;
            ListNode nextNode = node.next;
            while (nextNode.next != null) {
                preNode = nextNode;
                nextNode = nextNode.next;
            }
            preNode.next = null;
            ListNode originNextNode = node.next;
            node.next = nextNode;
            nextNode.next = originNextNode;
            node = originNextNode;
        }
    }

    public static void main(String[] args) {
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
//        int k = 10;
        transfer(head);
        System.out.println(Arrays.toString(rebuildList(head)));
    }
}
