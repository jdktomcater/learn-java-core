package com.jdktomcat.pack.dsa.algorithm.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 快速排序
 */
public class AdvancedQuickSort extends RecursiveAction {

    private Integer[] array;

    private int start;

    private int end;

    public AdvancedQuickSort(Integer[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    /**
     * 计算
     */
    @Override
    protected void compute() {
        if (start < end) {
            int target = array[start];
            int i = start;
            int j = end + 1;
            while (true) {
                while (i < end && array[++i] <= target) ;
                while (j > start && array[--j] >= target) ;
                if (i < j) {
                    DataWrapUtil.swap(array, i, j);
                } else {
                    break;
                }
            }
            DataWrapUtil.swap(array, start, j);
            AdvancedQuickSort advancedQuickSortLeft = new AdvancedQuickSort(array, start, j - 1);
            AdvancedQuickSort advancedQuickSortRight = new AdvancedQuickSort(array, j + 1, end);
            advancedQuickSortLeft.fork();
            advancedQuickSortRight.fork();
            advancedQuickSortLeft.join();
            advancedQuickSortRight.join();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> dataList = new ArrayList<>(100000);
        String filePath = "C:\\Users\\Administrator\\Desktop\\number.txt";
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            dataList.add(Integer.parseInt(scanner.next().trim()));
        }
        scanner.close();
        Integer[] array = dataList.toArray(new Integer[0]);
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        long startTimeAdvanced = System.currentTimeMillis();
        pool.invoke(new AdvancedQuickSort(array, 0, array.length - 1));
        System.out.println(String.format("高级并行快速排序完成，耗时：%d ms", (System.currentTimeMillis() - startTimeAdvanced)));

        String targetPath = "C:\\Users\\Administrator\\Desktop\\sorted-a.txt";
        PrintWriter writer = new PrintWriter(targetPath);
        for (int i = 0; i < array.length; i++) {
            writer.println(array[i]);
        }
        writer.flush();
        writer.close();

    }
}
