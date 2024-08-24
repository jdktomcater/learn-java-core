package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p22;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import com.jdktomcat.pack.dsa.algorithm.book.offer.list.p21.DeleteReverseKthNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ListLoopEntryPointTest {

    @Test
    public void detectCycleWithNoCycle() {
        int[] target = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.build(target);
        ListNode node = ListLoopEntryPoint.detectCycle(head);
        Assert.assertNull(node);
    }

    @Test
    public void detectCycleWithCycle3() {
        int[] target = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.buildLoop(target, 3);
        ListNode node = ListLoopEntryPoint.detectCycle(head);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.value, 4);
    }

    @Test
    public void detectCycleWithCycle0() {
        int[] target = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.buildLoop(target, 0);
        ListNode node = ListLoopEntryPoint.detectCycle(head);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.value, 1);
    }

    @Test
    public void detectCycleWithCycle5() {
        int[] target = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.buildLoop(target, 5);
        ListNode node = ListLoopEntryPoint.detectCycle(head);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.value, 6);
    }
}