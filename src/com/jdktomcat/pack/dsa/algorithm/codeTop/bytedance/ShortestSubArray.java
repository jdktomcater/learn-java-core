package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class ShortestSubArray {

    /**
     * 长度最小的子数组长度
     *
     * @param target  目标值
     * @param numbers 数组
     * @return 长度最小的子数组长度
     */
    public static int minSubArrayLen(int target, int[] numbers) {
        int min = numbers.length + 1;
        int left = 0, right = 0, sum = numbers[0];
        while (right < numbers.length) {
            if (sum == target) {
                min = Math.min(min, right - left + 1);
                right++;
                sum += right < numbers.length ? numbers[right] : 0;
            } else if (sum < target) {
                right++;
                sum += right < numbers.length ? numbers[right] : 0;
            } else {
                min = Math.min(min, right - left + 1);
                sum -= numbers[left];
                left++;
            }
        }
        return min > numbers.length ? 0 : min;
    }

    public static int minSubArrayLenL1(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 直观暴力解法
     */
    public int minSubArrayLenL5(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= s) return 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 滑动窗口解法
     *
     * @param s    目标值
     * @param nums 数组
     * @return 结果
     */
    public int minSubArrayLenL4(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 滑动窗口解法
     *
     * @param s    目标值
     * @param nums 数组
     * @return 结果
     */
    public int minSubArrayLenL3(int s, int[] nums) {
        int lo = 0, hi = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            s -= nums[hi++];
            while (s <= 0) {
                min = Math.min(min, hi - lo);
                s += nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 11;
        System.out.println(minSubArrayLen(target, numbers));
    }

}
