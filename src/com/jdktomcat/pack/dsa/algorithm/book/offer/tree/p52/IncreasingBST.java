package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p52;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.Stack;

/**
 * 展评二叉搜索树
 */
public class IncreasingBST {

    /**
     * 展平二叉搜索树
     *
     * @param root 树根节点
     * @return 二叉搜索树根节点
     */
    public static TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev != null) {
                prev.right = cur;
            } else {
                first = cur;
            }
            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }
}
