package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大二叉树
 */
public class ConstructMaximumBinaryTree {

    /**
     * 构造最大二叉树（单调栈）
     *
     * @param numbers 数组
     * @return 二叉树树根
     */
    public static TreeNode constructMaximumBinaryTreeStack(int[] numbers) {
        List<Integer> stack = new ArrayList<>();
        TreeNode[] tree = new TreeNode[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            tree[i] = new TreeNode(numbers[i], null, null);
            while (!stack.isEmpty() && numbers[i] > numbers[stack.get(stack.size() - 1)]) {
                tree[i].left = tree[stack.get(stack.size() - 1)];
                stack.remove(stack.size() - 1);
            }
            if (!stack.isEmpty()) {
                tree[stack.get(stack.size() - 1)].right = tree[i];
            }
            stack.add(i);
        }
        return tree[stack.get(0)];
    }

    /**
     * 构造最大二叉树（单调栈）
     *
     * @param numbers 数组
     * @return 二叉树树根
     */
    public static TreeNode constructMaximumBinaryTreeDfs(int[] numbers) {
        return construct(numbers, 0, numbers.length - 1);
    }

    /**
     * 构造函数
     *
     * @param numbers 数组
     * @param left    左边界
     * @param right   右边界
     * @return 构造树节点
     */
    public static TreeNode construct(int[] numbers, int left, int right) {
        if (left > right) {
            return null;
        }
        int bestIndex = getBiggestIndex(numbers, left, right);
        return new TreeNode(numbers[bestIndex], construct(numbers, left, bestIndex - 1), construct(numbers, bestIndex + 1, right));
    }

    /**
     * 获取最大索引
     *
     * @param numbers 数组
     * @param left    左索引
     * @param right   右索引
     * @return 最大索引
     */
    private static int getBiggestIndex(int[] numbers, int left, int right) {
        int best = left;
        for (int i = left + 1; i <= right; ++i) {
            if (numbers[i] > numbers[best]) {
                best = i;
            }
        }
        return best;
    }
}
