package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {

    /**
     * 深度遍历到叶子节点
     *
     * @param root  根节点
     * @param node  目标节点
     * @param queue 缓存队列
     * @return true:找到目标 false:没有找到
     */
    private static boolean findNode(TreeNode root, TreeNode node, LinkedList<TreeNode> queue) {
        // 先将根节点加入队列
        queue.offer(root);
        // 判断节点是否与目标节点相同
        if (root == node) {
            // 找到目标值，返回
            return true;
        }
        // 左节点
        if (root.left != null) {
            // 从左节点路径出发遍历
            boolean findLeft = findNode(root.left, node, queue);
            // 没有找到
            if (!findLeft) {
                // 去掉最后节点
                queue.removeLast();
            } else {
                // 找到则返回
                return true;
            }
        }
        // 右节点
        if (root.right != null) {
            // 从右节点路径出发遍历
            boolean findRight = findNode(root.right, node, queue);
            // 没有找到
            if (!findRight) {
                // 去掉最后节点
                queue.removeLast();
            } else {
                // 找到则返回
                return true;
            }
        }
        // 返回未找到
        return false;
    }


    /**
     * 最低公共祖先
     *
     * @param root 树根节点
     * @param p    节点1
     * @param q    节点2
     * @return 最低公共祖先节点
     */
    public static TreeNode lowestCommonAncestorL1(TreeNode root, TreeNode p, TreeNode q) {
        // 从根节点到目标节点路径节点队列
        LinkedList<TreeNode> queueP = new LinkedList<>();
        LinkedList<TreeNode> queueQ = new LinkedList<>();
        // 计算路径队列
        findNode(root, p, queueP);
        findNode(root, q, queueQ);
        // 削平两个队列
        LinkedList<TreeNode> longer = queueP.size() > queueQ.size() ? queueP : queueQ;
        LinkedList<TreeNode> shorter = queueP.size() > queueQ.size() ? queueQ : queueP;
        int step = Math.abs(queueP.size() - queueQ.size());
        for (int i = 0; i < step; i++) {
            longer.removeLast();
        }
        // 查找相关共同祖先
        while (!longer.isEmpty() && !shorter.isEmpty()) {
            TreeNode nodeL = longer.removeLast();
            TreeNode nodeS = shorter.removeLast();
            if (nodeL == nodeS) {
                return nodeL;
            }
        }
        return null;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 判断节点是否为空或者与节点相同，直接返回节点
        if (root == null || p == root || q == root) {
            return root;
        }
        // 左路径搜索
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右路径搜索
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 判断左节点及右节点及根节点
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        Integer[] numbers = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNode.buildTree(numbers, 1);
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        TreeNode node = lowestCommonAncestor(root, p, q);
        System.out.println(node == null ? "" : node.val);
    }

}
