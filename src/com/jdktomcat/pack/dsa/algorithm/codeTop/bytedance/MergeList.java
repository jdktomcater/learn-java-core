package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;

/**
 * 链表合并
 */
public class MergeList {

    /**
     * 链表合并
     *
     * @param lists 链表数组
     * @return 合并后链表
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        // 哨兵节点
        ListNode dummy = new ListNode(0);
        // 游标节点
        ListNode cur = dummy;
        // 循环处理
        while (true) {
            // 最小下标
            int minIndex = 0;
            // 数据已全部完成标识
            boolean allClean = true;
            // 遍历所有链表
            for (int index = 0; index < lists.length; index++) {
                // 取其头节点
                ListNode head = lists[index];
                // 判断是否空
                if (head != null) {
                    // 比对，取小下标
                    if (lists[minIndex] == null || head.value < lists[minIndex].value) {
                        minIndex = index;
                    }
                    // 处理完成标识置false
                    allClean = false;
                }
            }
            // 如果全部完成，跳出循环
            if (allClean) {
                break;
            }
            // 节点控制
            cur.next = lists[minIndex];
            cur = cur.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return dummy.next;
    }

    /**
     * 链表合并
     *
     * @param lists 链表数组
     * @return 合并后链表
     */
    public static ListNode mergeKListsL0(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeList(head, lists[i]);
        }
        return head;
    }

    /**
     * 链表合并(分治，速度最快)
     *
     * @param lists 链表数组
     * @return 合并后链表
     */
    public static ListNode mergeKListsL1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 合并
     *
     * @param lists 数组
     * @param left  左索引
     * @param right 右索引
     * @return
     */
    public static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeList(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    /**
     * 合并两个链表
     *
     * @param head1 链表1
     * @param head2 链表2
     * @return 合并后链表头结点
     */
    private static ListNode mergeList(ListNode head1, ListNode head2) {
        // 哨兵节点
        ListNode dummy = new ListNode(0);
        // 游标节点
        ListNode cur = dummy;
        // 游标节点A
        ListNode nodeA = head1;
        // 游标节点B
        ListNode nodeB = head2;
        while (nodeA != null && nodeB != null) {
            if (nodeA.value >= nodeB.value) {
                cur.next = nodeB;
                nodeB = nodeB.next;
            } else {
                cur.next = nodeA;
                nodeA = nodeA.next;
            }
            cur = cur.next;
        }
        if (nodeA != null) {
            cur.next = nodeA;
        }
        if (nodeB != null) {
            cur.next = nodeB;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        int[][] numbers = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] nodes = new ListNode[numbers.length];
        for (int index = 0; index < numbers.length; index++) {
            nodes[index] = ListNode.build(numbers[index]);
        }
        ListNode head = mergeKListsL0(nodes);
        System.out.println(Arrays.toString(ListNode.rebuild(head)));
    }

}
