package com.jdktomcat.interview.google;

import java.util.HashMap;
import java.util.Map;

public class GasStation {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int index = 0; index < gas.length; index++) {
            int ori = index;
            int start = -1;
            int total = gas[index] - cost[index];
            if (total >= 0) {
                while (start != index && total >= 0) {
                    start = (++ori) % gas.length;
                    total -= cost[start];
                    total += gas[start];
                }
                if (start == index && total >= 0) {
                    return index;
                }
            }
        }
        return -1;
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int total = 0;
        int[] pre = new int[gas.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < gas.length; i++) {
            pre[i] = gas[i] - cost[i];
            total += pre[i];
            map.put(i, total);
        }
        if (total < 0) {
            return -1;
        }
        return -1;
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        // 判断参数
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        // 起始和
        int sum = 0;
        // 总和
        int total = 0;
        // 索引
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }
        return total < 0 ? -1 : index + 1;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit2(a, b));
    }

}
