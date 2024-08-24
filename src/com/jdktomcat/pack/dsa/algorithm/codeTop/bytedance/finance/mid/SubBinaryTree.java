package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 树的子树
 */
public class SubBinaryTree {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。（先序遍历）
     *
     * @param root1 树根节点1
     * @param root2 树根节点2
     * @return true：是 false：否
     */
    public static boolean isSubStructure(TreeNode root1, TreeNode root2) {
        return (root1 != null && root2 != null) && (recur(root1, root2) || isSubStructure(root1.left, root2) || isSubStructure(root1.right, root2));
    }

    /**
     * 判断是否一致
     *
     * @param root1 树根节点1
     * @param root2 树根节点2
     * @return true：是 false：否
     */
    private static boolean recur(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return recur(root1.left, root2.left) && recur(root1.right, root2.right);
    }
}
