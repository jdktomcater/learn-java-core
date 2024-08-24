package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 最接近的二叉搜索树值
 */
public class BstNearestTarget {

    /**
     * 最接近的二叉搜索树值
     * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
     * 注意：
     * 给定的目标值 target 是一个浮点数
     * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
     *
     * @param root   二叉搜索树根节点
     * @param target 目标值
     * @return 距离最近节点值
     */
    public static int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }

}
