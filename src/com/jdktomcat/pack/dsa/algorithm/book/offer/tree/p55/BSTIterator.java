package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p55;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 */
public class BSTIterator {

    TreeNode cur;

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}
