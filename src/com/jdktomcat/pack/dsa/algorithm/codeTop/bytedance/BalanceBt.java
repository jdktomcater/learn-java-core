package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

/**
 * 平衡二叉树
 */
public class BalanceBt {

    /**
     * 判断是否为平衡二叉树
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * @param root 树根节点
     * @return true：是 false：否
     */
    public static boolean isBalanced(TreeNode root) {
        boolean[] result = {true};
        dfs(root, 1, result);
        return result[0];
    }

    /**
     * 深度计算逻辑
     *
     * @param root   树根节点
     * @param level  层级
     * @param result 结果
     */
    private static void dfs(TreeNode root, int level, boolean[] result) {
        if (result[0] && root != null) {
            int lefDepth = depth(root.left, level + 1);
            int rightDepth = depth(root.right, level + 1);
            if (Math.abs(lefDepth - rightDepth) > 1) {
                result[0] = false;
            } else {
                dfs(root.left, level + 1, result);
                dfs(root.right, level + 1, result);
            }
        }
    }

    /**
     * 树深度
     *
     * @param root  树根节点
     * @param level 层级
     * @return 深度
     */
    private static int depth(TreeNode root, int level) {
        if (root != null) {
            return Math.max(depth(root.left, level + 1), depth(root.right, level + 1));
        } else {
            return level - 1;
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 2, 3, 3, null, null, 4, 4};
        System.out.println(isBalanced(TreeNode.buildTree(numbers, 1)));
    }

}
