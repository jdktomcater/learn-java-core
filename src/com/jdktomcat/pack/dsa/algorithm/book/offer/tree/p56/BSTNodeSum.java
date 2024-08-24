package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p56;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 二叉搜索树中两个节点值之和
 */
public class BSTNodeSum {

    /**
     * 判断二叉搜索树中两个节点值之和是否为目标值
     *
     * @param root 树根节点
     * @param k    目标值
     * @return true：存在 false：不存在
     */
    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (set.contains(k - cur.val)) {
                return true;
            }
            set.add(cur.val);
            cur = cur.right;
        }
        return false;
    }
}
