package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 缺失的第一个正数
 */
public class FirstMissingPositive {

    /**
     * 查找缺失的第一个正整数
     * <p>
     * 我们将数组中所有小于等于 0 的数修改为 N+1；
     * <p>
     * 我们遍历数组中的每一个数 x，它可能已经被打了标记，因此原本对应的数为 |x|，其中 |\,|∣∣ 为绝对值符号。
     * 如果 |x| \in [1, N]，那么我们给数组中的第 |x| - 1 个位置的数添加一个负号。注意如果它已经有负号，不需要重复添加；
     * <p>
     * 在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1，否则答案是第一个正数的位置加 1。
     *
     * @param numbers 目标数组
     * @return 查找缺失的第一个正整数
     */
    public static int firstMissingPositive(int[] numbers) {
        // 数组长度
        int n = numbers.length;
        // 将小于0 的数设置为长度+1
        for (int i = 0; i < n; ++i) {
            if (numbers[i] <= 0) {
                numbers[i] = n + 1;
            }
        }
        // 将数组中元素值小于长度的
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(numbers[i]);
            // 在[1,N]区间
            if (num <= n) {
                // 将其对应下标处设置为其负绝对值
                numbers[num - 1] = -Math.abs(numbers[num - 1]);
            }
        }
        // 再次遍历，找到大于0的
        for (int i = 0; i < n; ++i) {
            if (numbers[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /**
     * 查找缺失的第一个正整数
     *
     * @param numbers 数组
     * @return 缺失的第一个正整数
     */
    public static int firstMissingPositiveL0(int[] numbers) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            while (numbers[i] > 0 && numbers[i] <= len && numbers[numbers[i] - 1] != numbers[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(numbers, numbers[i] - 1, i);
            }
        }
        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (numbers[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    /**
     * 数组交换
     *
     * @param numbers 数组
     * @param index1  下标1
     * @param index2  小标2
     */
    private static void swap(int[] numbers, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(numbers));
    }
}
