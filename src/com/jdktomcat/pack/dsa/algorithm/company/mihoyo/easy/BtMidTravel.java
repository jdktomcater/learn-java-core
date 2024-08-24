package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.easy;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class BtMidTravel {

    /**
     * 二叉树中序遍历
     *
     * @param root 树根节点
     * @return 中序遍历列表
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        travel(root, order);
        return order;
    }

    /**
     * 访问
     *
     * @param root  树根
     * @param order 列表
     */
    private static void travel(TreeNode root, List<Integer> order) {
        if (root == null) {
            return;
        }
        travel(root.left, order);
        order.add(root.val);
        travel(root.right, order);
    }

}
