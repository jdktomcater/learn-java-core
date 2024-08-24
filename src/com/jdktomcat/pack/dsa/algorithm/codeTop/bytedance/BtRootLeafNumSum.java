package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 求根节点到叶节点数字之和
 */
public class BtRootLeafNumSum {

    /**
     * 求根节点到叶节点数字之和
     * <p>
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     * <p>
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     * <p>
     * 叶节点 是指没有子节点的节点。
     *
     * @param root 树根节点
     * @return 根节点到叶节点数字之和
     */
    public static int btSumNumbers(TreeNode root) {
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

    public static void main(String[] args) {
        Integer[] numbers = {4, 9, 0, 5, 1};
        TreeNode root = TreeNode.buildTree(numbers, 1);
        System.out.println(btSumNumbers(root));
    }

}
