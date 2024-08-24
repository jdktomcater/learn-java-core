package com.jdktomcat.pack.dsa.algorithm.book.offer.util;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;

/**
 * 数组交换工具
 */
public class SwapUtil {

    /**
     * 数据交换
     *
     * @param numbers 数组
     * @param i       下标1
     * @param j       小标2
     */
    public static void swap(int[] numbers, int i, int j) {
        if (i != j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    /**
     * 交换节点信息
     *
     * @param node1 节点1
     * @param node2 节点2
     */
    public static void swap(ListNode node1, ListNode node2) {
        if (node1 != null && node2 != null) {
            int temp = node1.value;
            node1.value = node2.value;
            node2.value = temp;
        }
    }

}
