package com.jdktomcat.pack.dsa.algorithm.leetcode.d20220416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类概述：算法练习01
 *
 * @author tangqi
 * @date 2022-04-16
 */
public class Practise01 {

    /**
     * 树节点类
     */
    public static class TreeNode {
        /**
         * 值
         */
        int val;

        /**
         * 左节点
         */
        TreeNode left;

        /**
         * 右节点
         */
        TreeNode right;

        /**
         * 构造器
         *
         * @param val 值
         */
        TreeNode(int val) {
            this.val = val;
        }

        /**
         * 构造器
         *
         * @param val   值
         * @param left  左节点
         * @param right 右节点
         */
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 前序遍历
     *
     * @param root 根节点
     * @return 数据
     */
    private void preScan(TreeNode root, List<Integer> dataList) {
        dataList.add(root.val);
        if (root.left != null) {
            preScan(root.left, dataList);
        }
        if (root.right != null) {
            preScan(root.right, dataList);
        }
    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     * @return 数据
     */
    private void postScan(TreeNode root, List<Integer> dataList) {
        if (root.left != null) {
            postScan(root.left, dataList);
        }
        if (root.right != null) {
            postScan(root.right, dataList);
        }
        dataList.add(root.val);
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     * @return 数据
     */
    private void midScan(TreeNode root, List<Integer> dataList) {
        if (root.left != null) {
            midScan(root.left, dataList);
        }
        dataList.add(root.val);
        if (root.right != null) {
            midScan(root.right, dataList);
        }
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     * @return 数据
     */
    private void levelScan(TreeNode root, List<TreeNode> dataList) {
        dataList.add(root);
        while (true) {
            int length = dataList.size();
            TreeNode treeNode = dataList.get(length - 1);
            if (treeNode.left != null) {
                dataList.add(treeNode.left);
            }
            if (treeNode.right != null) {
                dataList.add(treeNode.right);
            }
            if (treeNode.left == null && treeNode.right == null) {
                break;
            }
        }
    }


    /**
     * 前序构造树
     *
     * @param preData 数据
     */
    private void preBuildTree(int[] preData, int level, List<TreeNode> rootList) {
        for (int index = 1; index < preData.length; index++) {
            TreeNode root = new TreeNode(preData[0]);
            TreeNode node = new TreeNode(preData[1]);
//            root

        }
    }

    /**
     * 前序构造树
     *
     * @param root 数据
     * @return 根节点
     */
    private boolean postMatch(TreeNode root, int[] postData) {
        return false;
    }


    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (n == 1) {
            return root;
        }

        int m = 0;
        for (int i = 0; i < n; ++i) {
            if (preorder[i] == preorder[1]) {
                m = i + 1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, m + 1), Arrays.copyOfRange(postorder, 0, m));
        root.right = constructFromPrePost(Arrays.copyOfRange(preorder, m + 1, n), Arrays.copyOfRange(postorder, m, n - 1));
        return root;
    }

    public static void main(String[] args) {

    }
}
