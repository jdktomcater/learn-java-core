package com.jdktomcat.pack.dsa.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * 类描述：运行类
 *
 * @author 11072131
 * @date 2020-04-2020/4/3 17:19
 */
public class Runner {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{23, 12, 1, 456, 67, 8, 9, 879, 32, 18, 101, 74, 99, 544, 754, 1023};
        long startTimeOriginal = System.currentTimeMillis();
        OriginalQuickSort.quickSort(array, 0, array.length - 1);
        System.out.println(String.format("原始快速排序完成，耗时：%d ms", (System.currentTimeMillis() - startTimeOriginal)));
        System.out.println(Arrays.toString(array));
        ForkJoinPool pool = new ForkJoinPool();
        long startTimeAdvanced = System.currentTimeMillis();
        pool.invoke(new AdvancedQuickSort(array, 0, array.length - 1));

    }
}
