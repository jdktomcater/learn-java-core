package com.jdktomcat.pack.dsa.algorithm.leetcode.hard;

/**
 * 类描述：链表合并
 *
 * @author 汤旗
 * @date 2019-11-07 11:34
 */
public class ListNodeMerge {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode headNode = new ListNode(Integer.MIN_VALUE);
        ListNode itNode = headNode;
        do{
            for (ListNode node : lists) {
                if(node.val < itNode.val){
                    itNode.next = node;
                    itNode = node;
                    node = node.next;

                }
            }
            break;
        } while (true);

        return headNode;
    }

}


