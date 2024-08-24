package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层次遍历
 */
public class BtLevelTravel {

    /**
     * 二叉树层次遍历(双队列)
     *
     * @param root 二叉树根节点
     * @return 二叉树层次遍历节点列表
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            level.add(node.val);
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()) {
                result.add(level);
                level = new ArrayList<>();
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }

    /**
     * 二叉树层次遍历（单队列）
     *
     * @param root 二叉树根节点
     * @return 二叉树层次遍历节点列表
     */
    public static List<List<Integer>> levelOrderL0(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 数的最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        int[] result = {0};
        dfs(root, 1, result);
        return result[0];
    }


    /**
     * 深度遍历逻辑
     *
     * @param root   根节点
     * @param depth  深度
     * @param result 结果
     */
    private static void dfs(TreeNode root, int depth, int[] result) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                result[0] = Math.max(depth, result[0]);
            } else {
                dfs(root.left, depth + 1, result);
                dfs(root.right, depth + 1, result);
            }
        }
    }
}
