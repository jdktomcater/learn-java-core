package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p21;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DeleteReverseKthNodeTest {

    /**
     * 普通场景测试用例
     */
    @Test
    public void removeKthFromEndNormal() {
        int[] target = {1, 2, 3, 4, 5, 6};
        int k = 2;
        ListNode head = DeleteReverseKthNode.removeKthFromEnd(ListNode.build(target), k);
        String result = Arrays.toString(ListNode.rebuild(head));
        Assert.assertEquals("[1, 2, 3, 4, 6]", result);
    }

    /**
     * 边界场景：移除尾部节点测试用例
     */
    @Test
    public void removeKthFromEndEdgeTail() {
        int[] target = {1, 2, 3, 4, 5, 6};
        int k = 1;
        ListNode head = DeleteReverseKthNode.removeKthFromEnd(ListNode.build(target), k);
        String result = Arrays.toString(ListNode.rebuild(head));
        Assert.assertEquals("[1, 2, 3, 4, 5]", result);
    }

    /**
     * 边界场景：移除头部节点测试用例
     */
    @Test
    public void removeKthFromEndEdgeHead() {
        int[] target = {1, 2, 3, 4, 5, 6};
        int k = 6;
        ListNode head = DeleteReverseKthNode.removeKthFromEnd(ListNode.build(target), k);
        String result = Arrays.toString(ListNode.rebuild(head));
        Assert.assertEquals("[2, 3, 4, 5, 6]", result);
    }
}