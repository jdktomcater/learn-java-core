package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.*;

/**
 * 二叉树展开为链表
 */
public class BtFlatten {

    /**
     * 二叉树展开为链表
     *
     * @param root 树根节点
     */
    public static void flatten(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        List<TreeNode> path = new ArrayList<>();
        while (node != null || !queue.isEmpty()) {
            while (node != null) {
                path.add(node);
                queue.push(node);
                node = node.left;
            }
            node = queue.pop();
            node = node.right;
        }
        TreeNode prev = root;
        if (path.size() > 1) {
            for (int i = 1; i < path.size(); i++) {
                prev.left = null;
                prev.right = path.get(i);
                prev = prev.right;
            }
        }
    }

}
