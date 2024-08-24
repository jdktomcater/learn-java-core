package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p53;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树的下一个节点
 */
public class BSTNextNode {

    /**
     * 二叉搜索树的下一个节点
     *
     * @param root 根节点
     * @param node 目标节点
     * @return 下一个节点
     */
    public static TreeNode inorderSuccessorL1(TreeNode root, TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean found = false;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (found) {
                break;
            } else if (node == cur) {
                found = true;
            }
            cur = cur.right;
        }
        return cur;
    }

    /**
     * 二叉搜索树的下一个节点
     *
     * @param root 根节点
     * @param node 目标节点
     * @return 下一个节点
     */
    public static TreeNode inorderSuccessorL0(TreeNode root, TreeNode node) {
        TreeNode cur = root;
        TreeNode result = null;
        while (cur != null) {
            if (cur.val > node.val) {
                result = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return result;
    }
}
