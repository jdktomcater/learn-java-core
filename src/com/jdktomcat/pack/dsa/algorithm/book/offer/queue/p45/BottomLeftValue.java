package com.jdktomcat.pack.dsa.algorithm.book.offer.queue.p45;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最低层最左边的值
 */
public class BottomLeftValue {

    /**
     * 二叉树最低层最左边的值
     *
     * @param root 树根
     * @return 目标值
     */
    public static int findBottomLeftValue(TreeNode root) {
        int bottomLeftVal = root.val;
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
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if (!queue1.isEmpty()) {
                    bottomLeftVal = queue1.peek().val;
                }
            }
        }
        return bottomLeftVal;
    }

}
