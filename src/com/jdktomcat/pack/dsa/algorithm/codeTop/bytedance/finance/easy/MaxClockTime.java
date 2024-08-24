package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

/**
 * 最大时间
 */
public class MaxClockTime {
    /**
     * 最大时间
     *
     * @param arr 数组
     * @return 最大时间
     */
    public static String largestTimeFromDigits(int[] arr) {
        String[] result = {""};
        dfs(arr, 0, result);
        return result[0];
    }

    private static void dfs(int[] arr, int index, String[] result) {
        if (index == arr.length && valid(arr)) {
            String time = String.format("%d%d:%d%d", arr[0], arr[1], arr[2], arr[3]);
            if (time.compareTo(result[0]) > 0) {
                result[0] = time;
            }
        } else if (index < arr.length) {
            for (int i = index; i < arr.length; i++) {
                swap(arr, i, index);
                dfs(arr, index + 1, result);
                swap(arr, i, index);
            }
        }
    }

    private static boolean valid(int[] arr) {
        if (arr[0] * 10 + arr[1] > 24) {
            return false;
        }
        return arr[2] * 10 + arr[3] <= 60;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        System.out.println(largestTimeFromDigits(numbers));
    }


}
