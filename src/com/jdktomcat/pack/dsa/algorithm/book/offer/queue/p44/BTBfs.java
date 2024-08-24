package com.jdktomcat.pack.dsa.algorithm.book.offer.queue.p44;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的广度优先搜索
 */
public class BTBfs {

    /**
     * 二叉树的广度优先搜索
     *
     * @param root 树根节点
     * @return 路径
     */
    public static List<Integer> bfs(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                path.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return path;
    }

    /**
     * 获取各层最大节点
     *
     * @param root 根节点
     * @return 获取各层最大节点
     */
    public static List<Integer> levelLargestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node != null) {
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
            }
            if (queue1.isEmpty()) {
                result.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }

}
