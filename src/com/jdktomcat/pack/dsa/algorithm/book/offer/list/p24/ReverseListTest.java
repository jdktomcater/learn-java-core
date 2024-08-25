package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p24;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ReverseListTest {

    @Test
    public void reverseListNormal() {
        int[] target = {1, 2, 3, 4, 5, 6};
        ListNode head = ReverseList.reverseList(ListNode.build(target));
        String result = Arrays.toString(ListNode.rebuild(head));
        Assert.assertEquals("[6, 5, 4, 3, 2, 1]", result);
    }

    @Test
    public void reverseListEdgeNull() {
        int[] target = {};
        ListNode head = ReverseList.reverseList(ListNode.build(target));
        String result = Arrays.toString(ListNode.rebuild(head));
        Assert.assertEquals("[]", result);
    }

    @Test
    public void reverseListEdgeOne() {
        int[] target = {1};
        ListNode head = ReverseList.reverseList(ListNode.build(target));
        String result = Arrays.toString(ListNode.rebuild(head));
        Assert.assertEquals("[1]", result);
    }
}