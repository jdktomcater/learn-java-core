package com.jdktomcat.pack.dsa.algorithm.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-10-14 20:18
 */
public class ListNodeHandle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int size = 0;
        Map<Integer, ListNode> dataMap = new HashMap<>(100000);
        while (node != null) {
            size++;
            dataMap.put(size, node);
            node = node.next;
        }
        int key = size - n + 1;
        int keyPre = size - n + 2;
        ListNode target = dataMap.get(key);
        ListNode preTarget = dataMap.get(keyPre);
        if (target != null) {
            if (target == head) {
                return head.next;
            }
            preTarget.next = target.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = removeNthFromEnd(head, 2);
        System.out.println(node.val);
    }
}
