package com.jdktomcat.pack.dsa.algorithm.book.offer.queue.p46;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右侧视图
 */
public class BTRightSideView {

    /**
     * 二叉树的右侧视图
     *
     * @param root 树根
     * @return 二叉树的右侧视图
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node != null) {
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
            }
            if (queue1.isEmpty()) {
                result.add(node.val);
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }

}
