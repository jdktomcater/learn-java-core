package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树右视图
 */
public class BtRightView {

    /**
     * 二叉树右视图
     *
     * @param root 二叉树根节点
     * @return 二叉树右视图节点列表
     */
    public static List<Integer> rightSideView(TreeNode root) {
        // 结果
        List<Integer> rightView = new ArrayList<>();
        // 判空
        if (root == null) {
            return rightView;
        }
        // 双队列实现二叉树层次访问
        Queue<TreeNode> queue1 = new LinkedList<>();
        // 放入队列中
        queue1.offer(root);
        // 备份队列
        Queue<TreeNode> queue2 = new LinkedList<>();
        // 截止条件
        while (!queue1.isEmpty()) {
            // 取头节点
            TreeNode node = queue1.poll();
            // 如果左节点不为空，放入备份队列中
            if (node.left != null) {
                queue2.add(node.left);
            }
            // 如果右节点不为空，放入备份队列中
            if (node.right != null) {
                queue2.add(node.right);
            }
            // 当处理队列为空，则说明层遍历完成，此时的node即为最右侧节点，放入结果
            // 然后将备份队列转为处理队列
            if (queue1.isEmpty()) {
                rightView.add(node.val);
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return rightView;
    }
}
