package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 删除排序链表中的重复元素 II
 */
public class RemoveRepeatListNode {

    /**
     * 删除排序链表中的重复元素 II
     *
     * @param head 链表头结点
     * @return 删除排序链表中的重复元素后链表节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode node = dummy.next;
        Map<Integer, ListNode[]> dataMap = new HashMap<>();
        while (node != null) {
            if (dataMap.containsKey(node.value)) {
                ListNode[] data = dataMap.get(node.value);
                if (data != null) {
                    data[0].next = data[2];
                    if (data[1] == pre) {
                        pre = data[0];
                    }
                    dataMap.put(node.value, null);
                }
                pre.next = node.next;
            } else {
                dataMap.put(node.value, new ListNode[]{pre, node, node.next});
                pre = node;
            }
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = deleteDuplicates(ListNode.build(numbers));
        System.out.println(Arrays.toString(ListNode.rebuild(head)));
    }

}
