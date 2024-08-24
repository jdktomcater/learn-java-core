package com.jdktomcat.pack.dsa.algorithm;

import java.util.*;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-05-21 21:41
 */
public class ListNumberAdd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        if (l1 != null && l2 != null) {
            node = new ListNode(l1.val + l2.val);
            node.next = addTwoNumbers(l1.next, l2.next);
            ListNode head = node;
            boolean isOver = head.val / 10 != 0;
            for (; isOver; head = head.next) {
                head.val = head.val % 10;
                if (head.next == null) {
                    head.next = new ListNode(1);
                } else {
                    head.next.val += 1;
                }
                isOver = head.next.val / 10 != 0;
            }
        } else if (l1 == null && l2 != null) {
            node = new ListNode(l2.val);
            node.next = addTwoNumbers(null, l2.next);
        } else if (l1 != null && l2 == null) {
            node = new ListNode(l1.val);
            node.next = addTwoNumbers(l1.next, null);
        }
        return node;
    }

    /**
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> dataList = new ArrayList<>(k);
        TreeMap<Integer, List<List<Integer>>> treeMap = new TreeMap<>();
        for (int number1 : nums1) {
            for (int number2 : nums2) {
                int sum = number1 + number2;
                List<List<Integer>> subList = treeMap.get(sum);
                if (subList == null) {
                    subList = new ArrayList<>();
                    treeMap.put(sum, subList);
                }
                List<Integer> subSubList = new ArrayList<>();
                subSubList.add(number1);
                subSubList.add(number2);
                subList.add(subSubList);
            }
        }
        int size = 0;
        Iterator<Integer> iterator = treeMap.keySet().iterator();
        while (size <= k && iterator.hasNext()) {
            List<List<Integer>> subList = treeMap.get(iterator.next());
            int sub = size < k ? subList.size() : k - size;
            dataList.addAll(subList.subList(0, sub));
            size += subList.size();
        }
        return dataList.subList(0, k);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> dataList = kSmallestPairs(nums1, nums2, k);
    }
}


