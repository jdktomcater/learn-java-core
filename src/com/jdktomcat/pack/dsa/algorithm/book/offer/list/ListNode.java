package com.jdktomcat.pack.dsa.algorithm.book.offer.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表节点
 */
public class ListNode {

    /**
     * 链表节点值
     */
    public int value;

    /**
     * 下一个节点指针
     */
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    /**
     * 构造
     *
     * @param array 目标数组
     * @return 链表头节点
     */
    public static ListNode build(int[] array) {
        ListNode dummy = new ListNode(0);
        if (array == null) {
            return dummy.next;
        }
        ListNode cur = dummy;
        for (int num : array) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 构造
     *
     * @param array 目标数组
     * @return 链表头节点
     */
    public static ListNode buildLoop(int[] array, int entry) {
        ListNode dummy = new ListNode(0);
        if (array == null) {
            return dummy.next;
        }
        ListNode cur = dummy;
        ListNode entryNode = null;
        for(int i=0;i< array.length;i++){
            ListNode node = new ListNode(array[i]);
            cur.next = node;
            cur = cur.next;
            if(i == entry){
                entryNode = node;
            }
        }
        cur.next = entryNode;
        return dummy.next;
    }


    /**
     * 反构造
     *
     * @param head 链表头节点
     * @return 数组
     */
    public static int[] rebuild(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.value);
            node = node.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 插入操作
     *
     * @param head 链表头结点
     * @param val  添加节点值
     * @return 头结点
     */
    public static ListNode append(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            return newNode;
        }
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return head;
    }

    /**
     * 插入操作
     *
     * @param head 链表头结点
     * @param val  添加节点值
     * @return 头结点
     */
    public static ListNode appendL0(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newNode = new ListNode(val);
        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return dummy.next;
    }

    /**
     * 删除节点
     *
     * @param head  表头
     * @param value 值
     * @return 删除目标节点后头结点
     */
    public static ListNode delete(ListNode head, int value) {
        if (head == null) {
            return null;
        }
        if (head.value == value) {
            return head.next;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.value == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }

    /**
     * 删除节点
     *
     * @param head  表头
     * @param value 值
     * @return 删除目标节点后头结点
     */
    public static ListNode deleteL0(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.value == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return dummy.next;
    }

    /**
     * 链表反转
     *
     * @param head 链表头节点
     * @return 反转后链表头节点
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    /**
     * 计算链表节点数量
     *
     * @param head 链表头结点
     * @return 链表长度
     */
    public static int countList(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }
}
