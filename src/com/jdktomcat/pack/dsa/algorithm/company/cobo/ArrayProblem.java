package com.jdktomcat.pack.dsa.algorithm.company.cobo;

import java.util.Arrays;

public class ArrayProblem {

    /**
     * 动态规划数组处理
     *
     * @param data 目标数组
     * @return 处理后结果
     */
    public static int[][] mergeArray(int[][] data) {
        // 目标数组异常判断不做处理，直接返回
        if (data == null || data.length < 2) {
            return data;
        }
        // 缓存处理结果
        int[][] result = new int[data[0].length][1];
        // 初始化动态规划数组，将目标数组0初始化
        for (int index = 0; index < data[0].length; index++) {
            result[index][0] = data[0][index];
        }
        // 循环处理
        for (int index = 0; index < data.length - 1; index++) {
            // 下一个数组
            int[] nextArr = data[index + 1];
            // 处理后结果
            int[][] dpArr = new int[result.length * nextArr.length][index + 2];
            // 结果索引
            int dpSubIndex = 0;
            for (int subIndex = 0; subIndex < result.length; subIndex++) {
                // 上次处理数组
                int[] preDpSubArr = result[subIndex];
                // 下一个数组循环处理
                for (int subNextIndex = 0; subNextIndex < nextArr.length; subNextIndex++) {
                    // 下一个处理结果数组
                    int[] nextDpSubArr = new int[preDpSubArr.length + 1];
                    // 将前一个处理结果拷贝
                    System.arraycopy(preDpSubArr, 0, nextDpSubArr, 0, preDpSubArr.length);
                    // 将下一个赋值
                    nextDpSubArr[preDpSubArr.length] = nextArr[subNextIndex];
                    // 组装
                    dpArr[dpSubIndex++] = nextDpSubArr;
                }
            }
            // 设值
            result = dpArr;
        }
        // 返回最后一个处理结果即可
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 5};
        int[] array2 = new int[]{2, 4};
        int[] array3 = new int[]{6, 9, 10, 12};
        int[] array4 = new int[]{16, 19, 110, 112};
        int[] array5 = new int[]{167, 191, 1110, 1124};
        int[][] data = new int[][]{array1, array2, array3, array4, array5};
        int[][] result = mergeArray(data);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
