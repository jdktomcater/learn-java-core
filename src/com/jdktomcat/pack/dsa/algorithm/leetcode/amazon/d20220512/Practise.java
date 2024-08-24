package com.jdktomcat.pack.dsa.algorithm.leetcode.amazon.d20220512;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 类概述：
 *
 * @author tangqi
 * @date 2022-05-11
 */
public class Practise {

    public static class ListNode {
        int val;
        ListNode next;
    }

    public static ListNode deleteRepeat(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if(node.val == node.next.val){
                node = node.next.next;
            }
        }

        return head;
    }


    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int mergeCount = 0;
        for (int index = 0; index < intervals.length - 1; index++) {
            if (intervals[index][1] >= intervals[index + 1][0]) {
                mergeCount++;
                intervals[index + 1][0] = intervals[index][0];
                intervals[index + 1][1] = Math.max(intervals[index][1], intervals[index + 1][1]);
                intervals[index] = null;
            }
        }
        int length = intervals.length - mergeCount;
        int[][] results = new int[length][2];
        int pos = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                results[pos++] = interval;
            }
        }
        return results;
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

}
