package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p49;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class SumAllPathTest {

    @Test
    public void sumAllPath() {
        Integer[] data = {3, 9, 0, 5, 1, null, 2};
        TreeNode root = TreeNode.buildTree(data, 1);
        int sum = SumAllPath.sumAllPath(root);
        Assert.assertEquals(1088, sum);
    }

    @Test
    public void sumAllPathEdgeEmpty() {
        Integer[] data = {};
        TreeNode root = TreeNode.buildTree(data, 1);
        int sum = SumAllPath.sumAllPath(root);
        Assert.assertEquals(0, sum);
    }

    @Test
    public void sumAllPathEdgeOnlyOne() {
        Integer[] data = {1};
        TreeNode root = TreeNode.buildTree(data, 1);
        int sum = SumAllPath.sumAllPath(root);
        Assert.assertEquals(1, sum);
    }
}