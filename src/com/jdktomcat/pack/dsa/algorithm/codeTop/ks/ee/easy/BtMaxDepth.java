package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 二叉树最大深度
 */
public class BtMaxDepth {

    /**
     * 树的最大深度
     *
     * @param root 树根节点
     * @return 最大深度
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private static void dfs(TreeNode root, int depth, int[] max) {
        if (root == null) {
            max[0] = Math.max(max[0], depth);
            return;
        }
        depth++;
        dfs(root.left, depth, max);
        dfs(root.right, depth, max);
    }

    private static int dfs1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs1(root.left), dfs1(root.right)) + 1;
    }
}
