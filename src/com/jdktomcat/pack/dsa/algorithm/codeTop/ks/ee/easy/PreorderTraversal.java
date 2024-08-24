package com.jdktomcat.pack.dsa.algorithm.codeTop.ks.ee.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 */
public class PreorderTraversal {

    /**
     * 二叉树前序遍历
     *
     * @param root 树根
     * @return 遍历链表
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        dfs(root, path);
        return path;
    }

    /**
     * 深度遍历
     *
     * @param root 树根节点
     * @param path 路径
     */
    private static void dfs(TreeNode root, List<Integer> path) {
        if (root != null) {
            path.add(root.val);
            dfs(root.left, path);
            dfs(root.right, path);
        }
    }
}
