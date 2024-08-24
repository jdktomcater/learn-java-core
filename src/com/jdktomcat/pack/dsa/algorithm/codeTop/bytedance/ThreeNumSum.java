package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;


import java.util.*;

/**
 * 三数之和
 */
public class ThreeNumSum {

    /**
     * 三数和
     *
     * @param numbers 数组
     * @param sum     和值
     * @return 所有组合
     */
    public static List<List<Integer>> threeNumSumPath(int[] numbers, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if (numbers.length < 3) {
            return result;
        }
        Set<String> unique = new HashSet<>();
        dfs(numbers, sum, 0, 0, path, result, unique);
        return result;
    }

    private static void dfs(int[] numbers, int sum, int total, int index, LinkedList<Integer> path, List<List<Integer>> result, Set<String> unique) {
        if (total == sum && path.size() == 3) {
            int[] array = path.stream().mapToInt(i -> i).toArray();
            Arrays.sort(array);
            if (unique.add(Arrays.toString(array))) {
                result.add(new LinkedList<>(path));
            }
        } else if (index < numbers.length) {
            dfs(numbers, sum, total, index + 1, path, result, unique);
            path.offer(numbers[index]);
            dfs(numbers, sum, total + numbers[index], index + 1, path, result, unique);
            path.removeLast();
        }
    }

    public static List<List<Integer>> threeSum(int[] numbers) {
        // 结果列表
        List<List<Integer>> result = new ArrayList<>();
        // 判断数组长度是否大于等于3
        if (numbers.length >= 3) {
            // 目标数组排序
            Arrays.sort(numbers);
            // 索引1,指向第一个数字
            int i = 0;
            // 控制其循环条件小于长度减二，也即是三数中最小值索引
            while (i < numbers.length - 2) {
                // 中间值索引
                int j = i + 1;
                // 最大值索引
                int k = numbers.length - 1;
                // 查找条件是中间值索引小于最大值索引
                while (j < k) {
                    // 如果三数之和为目标值的话，保留结果
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        // 结果集
                        result.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));
                        // 跳过相等值索引，去重
                        int temp = numbers[j];
                        while (numbers[j] == temp && j < k) {
                            ++j;
                        }
                    // 小于目标值的话，将中间索引右移，增大
                    } else if (numbers[i] + numbers[j] + numbers[k] < 0) {
                        ++j;
                    } else {
                        // 大于目标值的话，将最大值索引左移，减小
                        --k;
                    }
                }
                // 同样的道理，跳过相等值索引，去重
                int temp = numbers[i];
                while (i < numbers.length && numbers[i] == temp) {
                    ++i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(numbers);
        for (List<Integer> path : result) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
