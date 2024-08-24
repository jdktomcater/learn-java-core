package com.jdktomcat.pack.dsa.algorithm.leetcode.daily;

/**
 * 树节点
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public static TreeNode build(Integer[] nums, int index) {
        TreeNode root = null;
        if (index <= nums.length && nums[index - 1] != null) {
            root = new TreeNode();
            root.val = nums[index - 1];
            root.left = build(nums, 2 * index);
            root.right = build(nums, 2 * index + 1);
        }
        return root;
    }
}
