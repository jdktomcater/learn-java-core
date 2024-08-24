package com.jdktomcat.pack.dsa.algorithm.book.offer.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并区间
 */
public class Problem74 {

    /**
     * 区间合并
     *
     * @param target 目标数组
     * @return 合并后数组
     */
    public static int[][] merge(int[][] target) {
        Arrays.sort(target, Comparator.comparingInt(a -> a[0]));
        int index = 0;
        List<int[]> merged = new LinkedList<>();
        while (index < target.length) {
            int subIndex = index + 1;
            int[] subMerged = new int[]{target[index][0], target[index][1]};
            while (subIndex < target.length && subMerged[1] > target[subIndex][0]) {
                subMerged[1] = Math.max(subMerged[1], target[subIndex][1]);
                subIndex++;
            }
            index = subIndex;
            merged.add(subMerged);
        }
        int[][] merge = new int[merged.size()][];
        return merged.toArray(merge);
    }


    public static void main(String[] args) {
        int[][] target = new int[][]{
                new int[]{1,3},
                new int[]{4,5},
                new int[]{8,10},
                new int[]{2,6},
                new int[]{9,12},
                new int[]{15,18}
        };
        int[][] merge = merge(target);
        for (int[] array : merge) {
            System.out.println(Arrays.toString(array));
        }
    }

}
