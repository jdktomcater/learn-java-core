package com.jdktomcat.pack.dsa.algorithm.sort;

/**
 * 类描述：数据交换工具类
 *
 * @author 11072131
 * @date 2020-04-2020/4/3 17:06
 */
public class DataWrapUtil {

    /**
     * 交换
     *
     * @param array  数组
     * @param index1 下标1
     * @param index2 下标2
     */
    public static void swap(Integer[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
