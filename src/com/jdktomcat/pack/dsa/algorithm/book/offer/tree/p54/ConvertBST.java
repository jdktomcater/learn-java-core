package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p54;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.Stack;

/**
 * 所有大于等于节点的值之和
 */
public class ConvertBST {

    /**
     * 转化
     *
     * @param root 树根节点
     * @return 转化后树根
     */
    public static TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.right;
        }
        return root;
    }
}
