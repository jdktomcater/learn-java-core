package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p23;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class IntersectionNodeTest {

    @Test
    public void getIntersectionNodeNormal() {
        ListNode[] listNodes = ListNode.buildCoincide(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 4, 5, 6});
        ListNode node = IntersectionNode.getIntersectionNode(listNodes[0], listNodes[1]);
        Assert.assertNotNull(node);
        Assert.assertEquals(4, node.value);
    }

    @Test
    public void getIntersectionNodeEdgeNone() {
        ListNode[] listNodes = ListNode.buildCoincide(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 9, 10, 11});
        ListNode node = IntersectionNode.getIntersectionNode(listNodes[0], listNodes[1]);
        Assert.assertNull(node);
    }

    @Test
    public void getIntersectionNodeEdgeLast() {
        ListNode[] listNodes = ListNode.buildCoincide(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 9, 10, 6});
        ListNode node = IntersectionNode.getIntersectionNode(listNodes[0], listNodes[1]);
        Assert.assertNotNull(node);
        Assert.assertEquals(6, node.value);
    }

    @Test
    public void getIntersectionNodeEdgeFirst() {
        ListNode[] listNodes = ListNode.buildCoincide(new int[]{1, 2, 3, 4, 5, 6}, new int[]{3, 4, 5, 6});
        ListNode node = IntersectionNode.getIntersectionNode(listNodes[0], listNodes[1]);
        Assert.assertNotNull(node);
        Assert.assertEquals(3, node.value);
    }
}