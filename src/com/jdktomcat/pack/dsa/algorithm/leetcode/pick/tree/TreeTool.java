package com.jdktomcat.pack.dsa.algorithm.leetcode.pick.tree;

public class TreeTool {

    public static TreeNode generateTree(Integer[] dataArray) {
        if (dataArray == null || dataArray.length == 0) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[dataArray.length];
        TreeNode root = new TreeNode(dataArray[0]);
        nodes[0] = root;
        for (int index = 0; index < dataArray.length; index++) {
            TreeNode treeNode = nodes[index];
            if (treeNode != null) {
                TreeNode leftNode = 2 * index + 1 >= dataArray.length || dataArray[2 * index + 1] == null ? null : new TreeNode(dataArray[2 * index + 1]);
                treeNode.left = leftNode;
                TreeNode rightNode = 2 * index + 2 >= dataArray.length || dataArray[2 * index + 2] == null ? null : new TreeNode(dataArray[2 * index + 2]);
                treeNode.right = rightNode;
                nodes[index] = treeNode;
                if (2 * index + 1 < dataArray.length) {
                    nodes[2 * index + 1] = leftNode;
                }
                if (2 * index + 2 < dataArray.length) {
                    nodes[2 * index + 2] = rightNode;
                }
            }
        }
        return root;
    }
}
