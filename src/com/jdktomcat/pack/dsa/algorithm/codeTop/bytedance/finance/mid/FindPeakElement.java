package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

/**
 * 寻找峰值
 */
public class FindPeakElement {

    /**
     * 最大索引
     *
     * @param numbers 数组
     * @return 最大索引
     */
    public int findPeakElement(int[] numbers) {
        int idx = 0;
        for (int i = 1; i < numbers.length; ++i) {
            if (numbers[i] > numbers[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    public int findPeakElementL0(int[] numbers) {
        int left = 0, right = numbers.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (compare(numbers, mid - 1, mid) < 0 && compare(numbers, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            if (compare(numbers, mid, mid + 1) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
    // 方便处理 nums[-1] 以及 nums[n] 的边界情况
    public static int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }

    public static int compare(int[] numbers, int idx1, int idx2) {
        int[] num1 = get(numbers, idx1);
        int[] num2 = get(numbers, idx2);
        if (num1[0] != num2[0]) {
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }
}
