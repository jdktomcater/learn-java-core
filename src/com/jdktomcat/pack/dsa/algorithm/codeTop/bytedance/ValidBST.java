package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 验证二叉搜索树
 */
public class ValidBST {

    /**
     * 验证二叉搜索树
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

    public static void main(String[] args) {
        Integer[] numbers = {5, 4, 6, null, null, 3, 7};
        TreeNode root = TreeNode.buildTree(numbers, 1);
        System.out.println(isValidBST(root));
    }
}
