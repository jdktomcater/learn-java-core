package com.jdktomcat.pack.dsa.algorithm.book.offer.array.p7;

import java.util.*;

/**
 * 数组中和为0的三个数字
 */
public class ArrayElementSumZero {

    /**
     * 三数之和为0
     *
     * @param numbers 目标数组
     * @return 和组合
     */
    public static List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers.length >= 3) {
            Arrays.sort(numbers);
            int i = 0;
            while (i < numbers.length - 2) {
                twoSum(numbers, i, result);
                int temp = numbers[i];
                while (i < numbers.length && numbers[i] == temp) {
                    ++i;
                }
            }
        }
        return result;
    }

    /**
     * 两数和
     *
     * @param numbers 数组
     * @param i       下标
     * @param result  结果列表
     */
    private static void twoSum(int[] numbers, int i, List<List<Integer>> result) {
        int j = i + 1;
        int k = numbers.length - 1;
        while (j < k) {
            if (numbers[i] + numbers[j] + numbers[k] == 0) {
                result.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));
                int temp = numbers[j];
                while (numbers[j] == temp && j < k) {
                    ++j;
                }
            } else if (numbers[i] + numbers[j] + numbers[k] < 0) {
                ++j;
            } else {
                --k;
            }
        }
    }

    /**
     * 和为0的三个元素
     *
     * @param numbers 数组
     * @return 和为0的三个元素列表
     */
    public static List<List<Integer>> threeSumL0(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(numbers, 0, 0, 0, result, new LinkedList<>(), new HashSet<>());
        return result;
    }

    /**
     * 深度遍历计算
     *
     * @param numbers 数组
     * @param sum     和
     * @param index   索引
     * @param total   值和
     * @param result  结果
     * @param path    路径
     * @param pathSet 路径集合
     */
    private static void dfs(int[] numbers, int sum, int index, int total, List<List<Integer>> result, LinkedList<Integer> path, Set<String> pathSet) {
        if (path.size() == 3 && total == sum) {
            int[] pathArray = path.stream().mapToInt(i -> i).toArray();
            Arrays.sort(pathArray);
            if (pathSet.add(Arrays.toString(pathArray))) {
                result.add(new LinkedList<>(path));
            }
        } else if (path.size() < 3 && index < numbers.length) {
            dfs(numbers, sum, index + 1, total, result, path, pathSet);
            path.offer(numbers[index]);
            dfs(numbers, sum, index + 1, total + numbers[index], result, path, pathSet);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSumL0(numbers);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
