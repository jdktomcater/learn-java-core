package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开为链表
 */
public class BtFlattenList {

    /**
     * 二叉树展开为链表
     *
     * @param root 树根节点
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> path = new ArrayList<>();
        travel(root, path);
        TreeNode node = path.get(0);
        for (int i = 1; i < path.size(); i++) {
            TreeNode next = path.get(i);
            node.right = next;
            node.left = null;
            node = next;
        }
    }

    /**
     * 前序遍历
     *
     * @param root 树根
     * @param path 列表
     */
    private static void travel(TreeNode root, List<TreeNode> path) {
        if (root != null) {
            path.add(root);
            travel(root.left, path);
            travel(root.right, path);
        }
    }
}
