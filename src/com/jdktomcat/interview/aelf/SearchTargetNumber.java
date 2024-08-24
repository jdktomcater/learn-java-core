package com.jdktomcat.interview.aelf;

public class SearchTargetNumber {


    /**
     * 查找目标数据
     *
     * @param data   目标数组
     * @param target 目标数据
     * @param start  开始索引
     * @param end    解锁索引
     * @return 目标索引
     */
    public static int search(int[] data, int target, int start, int end) {
        if (data.length == 0 || start < 0 || end > data.length || start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (data[mid] == target) {
            return mid;
        } else {
            if (data[start] <= target && data[mid] >= target) {
                return search(data, target, start, mid - 1);
            } else if (data[end] >= target && data[mid] <= target) {
                return search(data, target, mid + 1, end);
            } else if (data[end] <= target && data[start] >= target) {
                return search(data, target, start, mid - 1);
            } else if (data[end] >= target && data[start] >= target) {
                return search(data, target, mid + 1, end);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {4, 5, 6, 1, 2, 3};
        int target = 4;
        System.out.println(search(data, target, 0, data.length - 1));
        target = 1;
        System.out.println(search(data, target, 0, data.length - 1));
        target = 7;
        System.out.println(search(data, target, 0, data.length - 1));
        target = 0;
        System.out.println(search(data, target, 0, data.length - 1));
    }
}
