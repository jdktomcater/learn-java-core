package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 验证是否是搜索二叉树
 */
public class ValidSearchBinaryTree {

    /**
     * 验证是否是搜索二叉树
     *
     * @param root 树根节点
     * @return true：是 false：否
     */
    public static boolean isValidBST(TreeNode root) {
        boolean[] valid = {true};
        if (root.left != null) {
            if (root.left.val >= root.val || max(root.left) >= root.val) {
                valid[0] = false;
            }
            dfs(root.left, valid);
        }
        if (root.right != null) {
            if (root.right.val <= root.val || min(root.right) <= root.val) {
                valid[0] = false;
            }
            dfs(root.right, valid);
        }
        return valid[0];
    }

    /**
     * 深度遍历逻辑
     *
     * @param root  根节点
     * @param valid 结果
     */
    private static void dfs(TreeNode root, boolean[] valid) {
        if (valid[0]) {
            if (root != null) {
                if (root.left != null) {
                    if (root.left.val >= root.val || max(root.left) >= root.val) {
                        valid[0] = false;
                    } else {
                        dfs(root.left, valid);
                    }
                }
                if (root.right != null) {
                    if (root.right.val <= root.val || min(root.right) <= root.val) {
                        valid[0] = false;
                    } else {
                        dfs(root.right, valid);
                    }
                }
            }
        }
    }

    /**
     * 求最小值
     *
     * @param root 根节点
     * @return 最小值
     */
    private static int min(TreeNode root) {
        if (root.left != null) {
            return min(root.left);
        } else {
            return root.val;
        }
    }

    /**
     * 求最大值
     *
     * @param root 根节点
     * @return 最大值
     */
    private static int max(TreeNode root) {
        if (root.right != null) {
            return max(root.right);
        } else {
            return root.val;
        }
    }

    /**
     * 递归
     *
     * @param root 树根节点
     * @return 是：true false：否
     */
    public boolean isValidBSTL0(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 深度计算逻辑
     *
     * @param node  节点
     * @param lower 下限
     * @param upper 上限
     * @return 是：true false：否
     */
    public boolean isValidBST(TreeNode node, int lower, int upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
