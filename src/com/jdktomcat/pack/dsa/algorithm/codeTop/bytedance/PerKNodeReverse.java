package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 每k个节点反转
 */
public class PerKNodeReverse {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        static ListNode build(int[] array) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            for (int num : array) {
                ListNode node = new ListNode(num);
                cur.next = node;
                cur = cur.next;
            }
            return dummy.next;
        }

        static int[] rebuild(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
            return list.stream().mapToInt(i -> i).toArray();
        }

        static int count(ListNode head) {
            int count = 0;
            ListNode node = head;
            while (node != null) {
                node = node.next;
                count++;
            }
            return count;
        }
    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(0), prev = dummy, curr = head, next;
        dummy.next = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        curr = dummy.next;
        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            curr = prev.next;
        }
        return dummy.next;
    }

    public static ListNode reverseKGroupStack(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (true) {
            int count = 0;
            ListNode temp = head;
            while (temp != null && count < k) {
                stack.add(temp);
                temp = temp.next;
                count++;
            }
            if (count != k) {
                node.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                node.next = stack.pop();
                node = node.next;
            }
            node.next = temp;
            head = temp;
        }
        return dummy.next;
    }


    public static ListNode reverseKGroupL1(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode preHead = head;
        ListNode node = dummy;
        while (true) {
            int count = 0;
            ListNode subNode = preHead;
            while (subNode != null && count < k) {
                stack.push(subNode);
                subNode = subNode.next;
                count++;
            }
            if (count != k) {
                node.next = preHead;
                break;
            }
            while (!stack.isEmpty()) {
                node.next = stack.pop();
                node = node.next;
            }
            node.next = subNode;
            preHead = subNode;
        }
        return dummy.next;
    }

    public static ListNode reverseKGroupL2(ListNode head, int k) {
        return reverseKGroup(head, k);
    }

    /**
     * 反转
     *
     * @param head 头节点
     * @param k    数量
     * @return 头节点
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 链表长度
        int count = 0;
        // 临时节点
        ListNode node = head;
        // 统计链表长度
        while (node != null) {
            node = node.next;
            count++;
        }
        // 判断链表长度是否大于k
        if (count >= k) {
            // 前节点
            ListNode prev = null;
            int t = k;
            // 重置头节点
            node = head;
            // 处理刻度
            while (t-- > 0) {
                // 下一个节点
                ListNode next = node.next;
                // 下一个节点
                node.next = prev;
                // 前置节点下移
                prev = node;
                // 节点信息移动
                node = next;
            }
            // 将反转后头节点下一个节点设置为后续处理头节点
            head.next = reverseKGroup(node, k);
            // 返回头节点即可
            return prev;
        } else {
            // 直接返回不做处理
            return head;
        }
    }

    /**
     * 反转
     *
     * @param head 表头
     * @return 反转后表头
     */
    public static ListNode reverse(ListNode head) {
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


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = reverseKGroupL2(ListNode.build(array), k);
        System.out.println(Arrays.toString(ListNode.rebuild(head)));
    }
}
