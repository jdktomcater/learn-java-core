package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p50;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class CountPathSumTest {

    @Test
    public void pathSum() {
        Integer[] numbers = new Integer[]{5, 2, 4, 1, 6, 3, 7};
        TreeNode root = TreeNode.buildTree(numbers, 1);
        int count = CountPathSum.pathSum(root, 8);
        Assert.assertEquals(2, count);
    }
}