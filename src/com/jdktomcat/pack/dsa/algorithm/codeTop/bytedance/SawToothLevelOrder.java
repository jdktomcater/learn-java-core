package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 */
public class SawToothLevelOrder {

    /**
     * 二叉树的锯齿形层序遍历
     *
     * @param root 树根节点
     * @return 遍历路径
     */
    public static List<List<Integer>> sawToothLevelOrder(TreeNode root) {
        // 结果
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 队列：处理信息
        Queue<TreeNode> queue1 = new LinkedList<>();
        // 根节点
        queue1.offer(root);
        // 队列：备份队列
        Queue<TreeNode> queue2 = new LinkedList<>();
        // 方向标识
        boolean isLeft = false;
        // 层节点列表
        List<Integer> levelList = new ArrayList<>();
        // 处理队列是否为空
        while (!queue1.isEmpty()) {
            // 取处理队列中的元素
            TreeNode node = queue1.poll();
            // 加入层节点列表中
            levelList.add(node.val);
            // 判断左节点
            if (node.left != null) {
                // 加入备份队列中
                queue2.offer(node.left);
            }
            // 判断右节点
            if (node.right != null) {
                // 加入备份队列中
                queue2.offer(node.right);
            }
            // 判断下处理队列中是否为空,也就是该层是否处理完成
            if (queue1.isEmpty()) {
                // 根据预设的标识来判断是否反转
                if (isLeft) {
                    Collections.reverse(levelList);
                }
                // 将结果放入结果集中
                result.add(levelList);
                // 重置层节点列表
                levelList = new ArrayList<>();
                // 反转标识
                isLeft = !isLeft;
                // 替换下一层
                queue1 = queue2;
                // 重置备份队列
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] target = {1, 2, 3, 4, null, null, 5};
        TreeNode root = TreeNode.buildTree(target, 1);
        List<List<Integer>> result = sawToothLevelOrder(root);
        for (List<Integer> level : result) {
            System.out.println(Arrays.toString(level.toArray()));
        }
    }
}
