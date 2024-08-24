package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;

/**
 * 字典序的第K小数字
 */
public class DictOrderKthNumber {

    /**
     * 字典序的第K小数字
     *
     * @param n 数范围
     * @param k 目标序列
     * @return 第K小数字
     */
    public static int findKthNumber(int n, int k) {
        int[][] numbers = new int[n + 1][11];
        for (int i = 1; i <= n; i++) {
            numbers[i] = change(i);
        }
        Arrays.sort(numbers, (num1, num2) -> {
            for (int i = 0; i < 10; i++) {
                if (num1[i] > num2[i]) {
                    return 1;
                } else if (num1[i] < num2[i]) {
                    return -1;
                }
            }
            return 0;
        });
        return numbers[k][10];
    }

    private static int[] change(int n) {
        int[] digit = new int[11];
        Arrays.fill(digit, -1);
        makeup(digit, n, 0);
        digit[10] = n;
        return digit;
    }

    /**
     * 组装
     *
     * @param digit 目标数组
     * @param n     目标值
     * @param i     索引
     * @return 下一个索引
     */
    private static int makeup(int[] digit, int n, int i) {
        if (n < 10) {
            digit[i] = n;
            return i + 1;
        } else {
            int bi = makeup(digit, n / 10, i);
            digit[bi] = n % 10;
            return bi + 1;
        }
    }

    public static int findKthNumberL0(int n, int k) {
        // 字典序从1开始
        int curr = 1;
        // 目标序
        k--;
        // 当目标序大于0时
        while (k > 0) {
            // 判断下以1开头的数字有多少
            int steps = getSteps(curr, n);
            // 如果小于k的话，说明需要往右走
            if (steps <= k) {
                // 减去已经处理节点数量
                k -= steps;
                // 目标值往右加1
                curr++;
            } else {
                // 目标值往下乘10
                curr = curr * 10;
                // 减去目标值
                k--;
            }
        }
        return curr;
    }

    /**
     * 节点数
     *
     * @param curr 目前值
     * @param n    边界值
     * @return 节点数
     */
    public static int getSteps(int curr, long n) {
        // 节点数
        int steps = 0;
        // 开始数
        long first = curr;
        // 最后数
        long last = curr;
        // 当开始数小于n时
        while (first <= n) {
            // 累加计算节点数
            steps += Math.min(last, n) - first + 1;
            // 循环处理
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }

    public static int findKthNumberL1(int n, int k) {
        long cur = 1;
        k -= 1;
        while (k > 0) {
            int nodes = getNodes(n, cur);
            if (k >= nodes) {
                k -= nodes;
                cur++;      //go right
            } else {
                k -= 1;
                cur *= 10;  //go down
            }
        }
        return (int) cur;
    }

    private static int getNodes(int n, long cur) {
        long next = cur + 1;
        long totalNodes = 0;
        while (cur <= n) {
            totalNodes += Math.min(n - cur + 1, next - cur);
            next *= 10;
            cur *= 10;
        }
        return (int) totalNodes;
    }

    public static void main(String[] args) {
        int n = 10000;
        int k = 10;
        System.out.println(findKthNumberL0(n, k));
//        int n = 1001;
//        System.out.println(Arrays.toString(change(n)));

    }

}
