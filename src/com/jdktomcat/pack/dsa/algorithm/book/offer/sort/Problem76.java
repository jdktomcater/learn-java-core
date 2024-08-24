package com.jdktomcat.pack.dsa.algorithm.book.offer.sort;

/**
 * 数组中取最k大数字
 */
public class Problem76 {

    /**
     * 查询第k大数字
     *
     * @param nums 目标数组
     * @param k    目标顺序
     * @return 目标数字
     */
    public static int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = QuickSort.partition(nums, start, end);
        while (index != target) {
            if (index > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = QuickSort.partition(nums, start, end);
        }
        return nums[index];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4, 5, 6, 5};
        int k = 3;
        int kth = findKthLargest(nums, k);
        System.out.println(kth);
    }

}
