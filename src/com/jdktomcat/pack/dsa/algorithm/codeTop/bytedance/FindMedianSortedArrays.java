package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 寻找两个有序数组的中位数
 */
public class FindMedianSortedArrays {

    /**
     * 寻找两个有序数组的中位数
     *
     * @param numbers1 数组1
     * @param numbers2 数组2
     * @return 中位数
     */
    public static double findMedianSortedArrays(int[] numbers1, int[] numbers2) {
        if ((numbers1.length + numbers2.length) % 2 == 1) {
            return getKthElement(numbers1, numbers2, (numbers1.length + numbers2.length) / 2 + 1);
        } else {
            return (getKthElement(numbers1, numbers2, (numbers1.length + numbers2.length) / 2) + getKthElement(numbers1, numbers2, (numbers1.length + numbers2.length) / 2 + 1)) / 2.0;
        }
    }

    /**
     * 寻找k个元素
     *
     * @param numbers1 数组1
     * @param numbers2 数组2
     * @param k        目标
     * @return 元素
     */
    public static int getKthElement(int[] numbers1, int[] numbers2, int k) {
        /*
         * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        int index1 = 0, index2 = 0;
        while (true) {
            // 边界情况
            if (index1 == numbers1.length) {
                return numbers2[index2 + k - 1];
            }
            if (index2 == numbers2.length) {
                return numbers1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(numbers1[index1], numbers2[index2]);
            }
            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, numbers1.length) - 1;
            int newIndex2 = Math.min(index2 + half, numbers2.length) - 1;
            int pivot1 = numbers1[newIndex1], pivot2 = numbers2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
