package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 求根节点到叶节点数字之和
 */
public class BtSumNode {

    public static int sumNumbers(TreeNode root) {
        int[] total = {0};
        dfs(root, total, 0);
        return total[0];
    }

    /**
     * 深度遍历计算
     *
     * @param root 树根节点
     * @param sum  和
     */
    private static void dfs(TreeNode root, int[] total, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            total[0] += (sum * 10 + root.val);
        }
        if (root.left != null) {
            dfs(root.left, total, sum * 10 + root.val);
        }
        if (root.right != null) {
            dfs(root.right, total, sum * 10 + root.val);
        }
    }
}
