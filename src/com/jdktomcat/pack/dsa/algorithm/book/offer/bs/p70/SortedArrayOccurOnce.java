package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p70;

/**
 * 排序数组中只出现一次的数字
 */
public class SortedArrayOccurOnce {

    /**
     * 排序数组中只出现一次的数字
     *
     * @param numbers 数组
     * @return 出现一次的数字
     */
    public static int singleNonDuplicate(int[] numbers) {
        int left = 0;
        int right = numbers.length / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid * 2;
            if (i < numbers.length - 1 && numbers[i] != numbers[i + 1]) {
                if (mid == 0 || numbers[i - 2] == numbers[i - 1]) {
                    return numbers[i];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return numbers[numbers.length - 1];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,1,2,2,3,4,4,5,5};
        System.out.println(singleNonDuplicate(numbers));
    }
}
