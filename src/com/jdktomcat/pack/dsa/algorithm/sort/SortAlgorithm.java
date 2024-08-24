package com.jdktomcat.pack.dsa.algorithm.sort;

import java.util.Arrays;

/**
 * 排序算法
 *
 * @author 汤旗
 * @date 2019-09-02
 */
public class SortAlgorithm {

    /**
     * 测试数据
     *
     * @param args
     */
    public static void main(String[] args) {
        DataWrap[] arrays = new DataWrap[]{
                new DataWrap(23, ""),
                new DataWrap(12, ""),
                new DataWrap(1, ""),
                new DataWrap(456, ""),
                new DataWrap(67, ""),
                new DataWrap(8, ""),
                new DataWrap(9, ""),
                new DataWrap(879, ""),
                new DataWrap(32, ""),
                new DataWrap(18, ""),
                new DataWrap(101, ""),
                new DataWrap(74, ""),
                new DataWrap(99, ""),
                new DataWrap(544, ""),
                new DataWrap(754, ""),
                new DataWrap(1023, "")
        };
        System.out.println("目标数据:");
        System.out.println(Arrays.toString(arrays));
        SortAlgorithm.quickSort(arrays);
    }

    /**
     * 堆排序算法实现
     *
     * @param arrays
     */
    public static void heapSort(DataWrap[] arrays) {
        System.out.println("堆排序开始......");

        // 外层循环遍历所有数据项
        for (int i = 0; i < arrays.length; i++) {
            // 创建大顶堆,也就是完全二叉树,以其最后子节点
            buildMaxHeap(arrays, arrays.length - 1 - i);
            // 交换最顶层与最后位数据
            swap(arrays, 0, arrays.length - 1 - i);
            // 打印排序过程
            System.out.println(Arrays.toString(arrays));
        }
        // 排序结果
        System.out.println("堆排序结束......");
        System.out.println(Arrays.toString(arrays));
    }

    /**
     * 创建大顶堆使最上层为最大值
     *
     * @param arrays    目标数据
     * @param lastIndex 最后的索引
     */
    private static void buildMaxHeap(DataWrap[] arrays, int lastIndex) {
        // 层循环,其中变量i存储层数,也即树的深度
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 临时变量k
            int k = i;
            // 判断节点是否到最后
            while (k * 2 + 1 <= lastIndex) {
                // 左子节点位置索引
                int biggerIndex = 2 * k + 1;
                // 判断索引是否越界
                if (biggerIndex < lastIndex) {
                    // 再比较该节点与其兄弟节点大小 如果小的话,则将取俩者之间较大者的索引
                    if (arrays[biggerIndex].compareTo(arrays[biggerIndex + 1]) < 0) {
                        // 将索引增1
                        biggerIndex++;
                    }
                }
                // 判断节点与父节点的大小
                if (arrays[k].compareTo(arrays[biggerIndex]) < 0) {
                    // 如果父节点比子节点小的话,交换
                    swap(arrays, k, biggerIndex);
                    // 并将k的索引赋子节点索引,以遍历交换后该节点下的分支,使该分支上的所有父节点均大于其子节点
                    k = biggerIndex;
                } else {
                    // 如果父节点比子节点大的话,则退出,进行下次外循环
                    break;
                }
            }
        }
    }

    /**
     * 交换数据,实现排序
     *
     * @param array
     * @param i
     * @param j
     */
    private static void swap(DataWrap[] array, int i, int j) {
        DataWrap temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 选择排序算法
     *
     * @param data
     */
    public static void selectSort(DataWrap[] data) {
        System.out.println("选择排序开始......");

        // 记录循环次数
        int loopNum = 0;
        // 记录交换次数
        int swapNum = 0;
        // 目标数据集的长度
        int length = data.length;
        // 外层循环遍历
        for (int i = 0; i < length - 1; i++) {
            // 内层循环遍历
            for (int j = i + 1; j < length; j++) {
                // 比较外层循环与内层循环指向的数据大小
                if (data[i].compareTo(data[j]) > 0) {
                    // 交换数据 从而保证每次外层循环总能得到内层循环中的最小值
                    swap(data, i, j);
                    // 交换次数增加
                    swapNum++;
                }
                // 循环次数增加
                loopNum++;
            }
            // 每次循环打出结果
            System.out.println(Arrays.toString(data));
        }
        // 排序结果及分析
        System.out.println("选择排序结束......");
        System.out.println(Arrays.toString(data));
        System.out.println("循环次数:" + loopNum);
        System.out.println("交换次数:" + swapNum);
    }

    /**
     * 选择排序改进版,通过减少交换次数提升性能
     *
     * @param data
     */
    public static void selectSort2(DataWrap[] data) {
        System.out.println("选择排序改进版开始......");

        // 记录循环次数
        int loopNum = 0;
        // 记录交换次数
        int swapNum = 0;

        // 目标数据长度
        int length = data.length;
        // 外层循环
        for (int i = 0; i < length - 1; i++) {
            // 记录最小值的索引
            int minIndex = i;
            // 内层循环
            for (int j = i + 1; j < length; j++) {
                // 比较外层循环指引值与内层循环指引值
                if (data[minIndex].compareTo(data[j]) > 0) {
                    // 记录最小值的索引 此处只需要记录其索引即可,无需交换,临时的,不是最小值
                    minIndex = j;
                }
                loopNum++;
            }
            // 判断最小值索引与外层循环索引是否相同,如果相同则无需交换
            if (minIndex != i) {
                // 交换值
                swap(data, i, minIndex);
                // 交换次数增张
                swapNum++;
            }
            // 打印排序过程
            System.out.println(Arrays.toString(data));
        }

        // 打印结果即对其分析
        System.out.println("选择排序改进版结束......");
        System.out.println(Arrays.toString(data));
        System.out.println("循环次数:" + loopNum);
        System.out.println("交换次数:" + swapNum);
    }

    /**
     * 冒泡排序
     *
     * @param data
     */
    public static void bubbleSort(DataWrap[] data) {
        System.out.println("冒泡排序开始:......");

        // 记录循环次数
        int loopNum = 0;
        // 记录交换次数
        int swapNum = 0;

        // 目标数据长度
        int length = data.length;
        // 外层循环
        for (int i = 0; i < length - 1; i++) {
            // 排序完成标识
            boolean swapFlg = false;
            // 内层循环
            for (int j = 0; j < length - 1 - i; j++) {
                // 比较相邻数据,如果前者大于后者的话
                if (data[j].compareTo(data[j + 1]) > 0) {
                    // 交换
                    swap(data, j, j + 1);
                    // 交换次数增1
                    swapNum++;
                    // 变换完成标识
                    swapFlg = true;
                }
                loopNum++;
            }
            System.out.println(Arrays.toString(data));
            // 判断排序是否完成
            if (!swapFlg) {
                break;
            }
        }
        System.out.println("冒泡排序结束:......");
        System.out.println(Arrays.toString(data));
        System.out.println("循环次数:" + loopNum);
        System.out.println("交换次数:" + swapNum);
    }

    /**
     * 快速排序
     *
     * @param data
     */
    public static void quickSort(DataWrap[] data) {
        System.out.println("快速排序开始:......");
        subSort(data, 0, data.length - 1);
        System.out.println("快速排序结束:......");
        System.out.println(Arrays.toString(data));
    }

    /**
     * 递归排序方法体
     *
     * @param data  目标数据
     * @param start 起始位置
     * @param end   终点位置
     */
    private static void subSort(DataWrap[] data, int start, int end) {
        // 判断位置大小
        if (start < end) {
            // 记录起始数据,标准
            DataWrap dataWrap = data[start];
            // 记录起始索引
            int i = start;
            // 记录终点索引
            int j = end + 1;
            // 循环
            while (true) {
                // 循环正向寻找从起始位置第一个小于起始数据的
                while (i < end && data[++i].compareTo(dataWrap) <= 0) ;
                // 循环反向寻找从终点位置第一个大于起始数据的
                while (j > start && data[--j].compareTo(dataWrap) >= 0) ;
                // 判断找到目标之后比较i,j值大小
                if (i < j) {
                    // 当i小于j时,交换
                    swap(data, i, j);
                } else {
                    // 否则跳出循环
                    break;
                }
            }
            // 交换起始位置与j位置数据
            swap(data, start, j);
            // 再递归缩小排序范围,左排序
            subSort(data, start, j - 1);
            // 再递归缩小排序范围,右排序
            subSort(data, j + 1, end);
        }
    }


    /**
     * 插入排序
     *
     * @param dataWraps
     */
    public static void insertSort(DataWrap[] dataWraps) {
        System.out.println("插入排序开始......");

        // 目标数据长度
        int length = dataWraps.length;
        // 外层循环
        for (int i = 1; i < length; i++) {
            // 记录循环数据
            DataWrap dataWrap = dataWraps[i];
            // 比较其与其前数据的大小
            if (dataWraps[i].compareTo(dataWraps[i - 1]) < 0) {
                // 当其小于前数据时
                int j = i - 1;
                // 将其前所有大于循环数据都前移
                for (; j >= 0 && dataWraps[j].compareTo(dataWrap) > 0; j--) {
                    dataWraps[j + 1] = dataWraps[j];
                }
                // 将第一次出现大于循环数据或首位置的索引处赋值
                dataWraps[j + 1] = dataWrap;
            }
            // 打印排序过程
            System.out.println(Arrays.toString(dataWraps));
        }
        System.out.println("插入排序结束......");
        System.out.println(Arrays.toString(dataWraps));
    }

    /**
     * 折分插入排序   也就是在插入排序的基础之上利用了之前序列是有序这一性质折半查找位置的
     *
     * @param datas
     */
    public static void binaryInsertSort(DataWrap[] datas) {
        System.out.println("折半插入排序开始......");

        // 目标数据的长度
        int length = datas.length;
        // 外层循环
        for (int i = 1; i < length; i++) {
            // 记录循环数据
            DataWrap dataWrap = datas[i];
            // 比较相邻数据大小
            if (datas[i].compareTo(datas[i - 1]) < 0) {
                // 小于前数据的情况
                // 记录低位
                int low = 0;
                // 记录高位
                int high = i - 1;
                // 当低位小于高位时
                while (low <= high) {
                    // 取两者中间位置
                    int mid = (low + high) / 2;
                    // 比较循环数据与中间位置大小
                    if (dataWrap.compareTo(datas[mid]) > 0) {
                        // 大于时,将中位加1当作低位
                        low = mid + 1;
                    } else {
                        // 小于时,将中位减1当作高位
                        high = mid - 1;
                    }
                }
                // 找到索引,将索引前的数据均前移
                for (int j = i; j > low; j--) {
                    datas[j] = datas[j - 1];
                }
                // 赋值
                datas[low] = dataWrap;
                System.out.println(Arrays.toString(datas));
            }
        }
        System.out.println("折半插入排序结束......");
        System.out.println(Arrays.toString(datas));
    }


    /**
     * 希尔排序   更加广泛意义的插入排序  插入排序为其特例
     *
     * @param dataArray 源数据数组
     */
    public static void shellSort(DataWrap[] dataArray) {
        System.out.println("希尔插入排序开始......");

        // 插入间隔
        int h = 1;
        // 目标数据长度
        int length = dataArray.length;
        // 寻找合适的间隔
        while (h <= length / 3) {
            h = h * 3 + 1;
        }

        // 最外层循环
        while (h > 0) {
            // 打印插入间距信息
            System.out.println("<======h的值:" + h + "========>");
            // 内层循环,起始为间距索引处
            for (int i = h; i < length; i++) {
                // 获取索引处数据
                DataWrap temp = dataArray[i];
                // 比较距离此索引处h间距最近的索引的值
                if (dataArray[i].compareTo(dataArray[i - h]) < 0) {
                    // 记录此处索引
                    int j = i - h;
                    // 找着第一个出现大于缓存值,其跳跃间距为h
                    for (; j >= 0 && dataArray[j].compareTo(temp) > 0; j -= h) {
                        // 将此前数据均后移
                        dataArray[j + h] = dataArray[j];
                    }
                    // 最后将此处位置赋为缓存值
                    dataArray[j + h] = temp;
                }
                // 打印排序过程
                System.out.println(Arrays.toString(dataArray));
            }
            // 变换间距
            h = (h - 1) / 3;
        }
        System.out.println("希尔插入排序结束......");
        System.out.println(Arrays.toString(dataArray));
    }

    /**
     * 合并排序
     *
     * @param dataArray 数据数组
     */
    public static void mergeSort(DataWrap[] dataArray) {
        System.out.println("合并排序开始......");
        sort(dataArray, 0, dataArray.length - 1);
        System.out.println("合并排序结束......");
        System.out.println(Arrays.toString(dataArray));
    }

    /**
     * 排序循环方法体
     *
     * @param dataArray 数据数组
     * @param left      左索引
     * @param right     右索引
     */
    private static void sort(DataWrap[] dataArray, int left, int right) {
        // 比较左边界与右边界的大小
        if (left < right) {
            // 当左边界小于右边界的情况, center记录左右中点
            int center = (left + right) / 2;
            // 左递归
            sort(dataArray, left, center);
            // 右递归
            sort(dataArray, center + 1, right);
            // 合并方法体
            merge(dataArray, left, center, right);
        }
    }

    /**
     * 合并
     *
     * @param dataArray 数据
     * @param left      左索引
     * @param center    中间
     * @param right     右索引
     */
    private static void merge(DataWrap[] dataArray, int left, int center, int right) {
        System.out.println("left:" + left + "; center:" + center + "; right:" + right);
        // 临时数组
        DataWrap[] tempArray = new DataWrap[dataArray.length];
        // mid记录中间索引
        int mid = center + 1;
        // third记录临时数组循环时引用,并初始其值为左边界
        int third = left;
        // 临时指针
        int temp = left;
        // 将数据合并到临时数组中
        while (left <= center && mid <= right) {
            // 比较左边界值与中间值的大小
            if (dataArray[left].compareTo(dataArray[mid]) > 0) {
                // 如果左边界值大于中间值的话,将中间值添加到临时数组中
                tempArray[third++] = dataArray[mid++];
            } else {
                // 相反,则将左边界值添加到临时数组中
                tempArray[third++] = dataArray[left++];
            }
        }
        System.out.println(Arrays.toString(tempArray));
        // 再将剩余数据统统添加到临时数组即可
        while (mid <= right) {
            tempArray[third++] = dataArray[mid++];
        }
        while (left <= center) {
            tempArray[third++] = dataArray[left++];
        }
        // 再将临时数组里copy到目标数组中
        while (temp <= right) {
            dataArray[temp] = tempArray[temp++];
        }
    }

    /**
     * 桶归并排序 ,有点毛病
     *
     * @param dataArray 数据数组
     * @param min       最小索引
     * @param max       最大索引
     */
    public static void bucketSort(DataWrap[] dataArray, int min, int max) {
        System.out.println("桶归并排序开始......");
        int arrayLength = dataArray.length;
        DataWrap[] tempArray = new DataWrap[arrayLength];
        int[] buckets = new int[max - min];
        for (int i = 0; i < arrayLength; i++) {
            buckets[dataArray[i].getValue() - min]++;
        }
        System.out.println(Arrays.toString(buckets));
        System.arraycopy(dataArray, 0, tempArray, 0, arrayLength);
        for (int k = arrayLength - 1; k >= 0; k--) {
            dataArray[--buckets[tempArray[k].getValue() - min]] = tempArray[k];
        }
        System.out.println("桶归并排序结束......");
        System.out.println(Arrays.toString(dataArray));
    }
}