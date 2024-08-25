package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p26;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReorderListTest {

    @Test
    public void reorderListEven() {
        int[] target = {1, 2, 3, 4, 5, 6};
        ListNode node = ListNode.build(target);
        ReorderList.reorderList(node);
        String result = Arrays.toString(ListNode.rebuild(node));
        Assert.assertEquals("[1, 6, 2, 5, 3, 4]",result);
    }

    @Test
    public void reorderListOdd() {
        int[] target = {1, 2, 3, 4, 5};
        ListNode node = ListNode.build(target);
        ReorderList.reorderList(node);
        String result = Arrays.toString(ListNode.rebuild(node));
        Assert.assertEquals("[1, 5, 2, 4, 3]",result);
    }

    @Test
    public void reorderListEdgeEmpty() {
        int[] target = {};
        ListNode node = ListNode.build(target);
        ReorderList.reorderList(node);
        String result = Arrays.toString(ListNode.rebuild(node));
        Assert.assertEquals("[]",result);
    }

    @Test
    public void reorderListEdgeOne() {
        int[] target = {1};
        ListNode node = ListNode.build(target);
        ReorderList.reorderList(node);
        String result = Arrays.toString(ListNode.rebuild(node));
        Assert.assertEquals("[1]",result);
    }
}