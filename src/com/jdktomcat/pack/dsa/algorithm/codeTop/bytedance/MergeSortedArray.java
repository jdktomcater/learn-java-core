package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;

/**
 * 合并排序数组
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */
public class MergeSortedArray {

    /**
     * 合并排序数组
     *
     * @param numbers1 数组1
     * @param m        长度1
     * @param numbers2 数组2
     * @param n        长度2
     */
    public static void merge(int[] numbers1, int m, int[] numbers2, int n) {
        int index1 = 0;
        int index2 = 0;
        while (m > 0 && n > 0) {
            if (numbers1[index1] > numbers2[index2]) {
                leftMove(numbers1, index1);
                numbers1[index1] = numbers2[index2];
                index2++;
                n--;
            } else {
                m--;
            }
            index1++;
        }
        if (n != 0) {
            for (int i = index2; i < n + index2; i++) {
                numbers1[index1++] = numbers2[i];
            }
        }
    }

    /**
     * 数组元素向右平移1位
     *
     * @param numbers 数组
     * @param start   开始索引处
     */
    private static void leftMove(int[] numbers, int start) {
        for (int i = numbers.length - 1; i > start; i--) {
            numbers[i] = numbers[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] numbers1 = {0};
        int m = 0;
        int[] numbers2 = {1};
        int n = 1;
        merge(numbers1, m, numbers2, n);
        System.out.println(Arrays.toString(numbers1));
    }

}
