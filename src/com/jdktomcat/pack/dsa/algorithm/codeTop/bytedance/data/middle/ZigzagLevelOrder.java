package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {

    /**
     * 锯齿形层序遍历
     *
     * @param root 树根节点
     * @return 锯齿形层序遍历列表
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);
        Queue<TreeNode> queue2 = new LinkedList<>();
        boolean isLeft = false;
        List<Integer> levelList = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            levelList.add(node.val);
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()) {
                if (isLeft) {
                    Collections.reverse(levelList);
                }
                result.add(levelList);
                levelList = new ArrayList<>();
                isLeft = !isLeft;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }
}
