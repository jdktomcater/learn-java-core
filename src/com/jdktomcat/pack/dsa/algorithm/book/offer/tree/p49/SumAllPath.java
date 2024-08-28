package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p49;


import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 从根节点到叶子节点的路径数字之和
 */
public class SumAllPath {

    /**
     * 计算所有路径和
     *
     * @param root 根节点
     * @return 路径和
     */
    public static int sumAllPath(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 深度路径和计算
     *
     * @param root 根节点
     * @param path 路径和
     * @return 和
     */
    private static int dfs(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        return dfs(root.left, path) + dfs(root.right, path);
    }
}
