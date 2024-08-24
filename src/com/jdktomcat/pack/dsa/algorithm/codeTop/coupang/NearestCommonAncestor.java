package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最近公共祖先
 */
public class NearestCommonAncestor {

    /**
     * 二叉搜索树的最近公共祖先
     *
     * @param root 二叉搜索树根
     * @param p    节点1
     * @param q    节点2
     * @return 最近公共祖先
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        int min = Math.min(pathP.size(), pathQ.size()) - 1;
        for (int i = min; i >= 0; i--) {
            if (pathP.get(i) == pathQ.get(i)) {
                return pathP.get(i);
            }
        }
        return null;
    }

    /**
     * 二叉搜索树查找节点路径
     *
     * @param root   树根节点
     * @param target 目标节点
     * @return 路径
     */
    private static List<TreeNode> getPath(TreeNode root, TreeNode target) {
        TreeNode node = root;
        List<TreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            if (node.val == target.val) {
                break;
            } else if (node.val > target.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return path;
    }

    /**
     * 最低公共祖先 (二叉树)
     *
     * @param root 树根节点
     * @param p    节点1
     * @param q    节点2
     * @return 最低公共祖先节点
     */
    public TreeNode lowestCommonAncestorL0(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestorL0(root.left, p, q);
        TreeNode right = lowestCommonAncestorL0(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

}
