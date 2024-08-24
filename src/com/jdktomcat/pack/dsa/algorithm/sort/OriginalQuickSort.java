package com.jdktomcat.pack.dsa.algorithm.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类描述：
 *
 * @author 11072131
 * @date 2020-04-2020/4/3 17:15
 */
public class OriginalQuickSort {
    /**
     * 快速排序
     *
     * @param array 数组
     * @param start 开始索引
     * @param end   结束索引
     */
    public static void quickSort(Integer[] array, int start, int end) {
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
            quickSort(array, start, j - 1);
            quickSort(array, j + 1, end);
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
        long startTimeOriginal = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        System.out.println(String.format("原始快速排序完成，耗时：%d ms", (System.currentTimeMillis() - startTimeOriginal)));
        String targetPath = "C:\\Users\\Administrator\\Desktop\\sorted-o.txt";
        PrintWriter writer = new PrintWriter(targetPath);
        for (int i = 0; i < array.length; i++) {
            writer.println(array[i]);
        }
        writer.flush();
        writer.close();
    }
}
