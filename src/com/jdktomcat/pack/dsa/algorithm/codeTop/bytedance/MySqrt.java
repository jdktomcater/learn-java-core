package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * x 的平方根
 * <p>
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class MySqrt {

    /**
     * x 的平方根
     *
     * @param x 目标值
     * @return 平方根
     */
    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 二分查找法
     *
     * @param target 目标数值
     * @return 平方根
     */
    public static int mySqrtL0(int target){
        int left = 1;
        int right = target;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid <= target / mid) {
                if ((mid + 1) > target / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

}
