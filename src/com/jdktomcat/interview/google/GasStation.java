package com.jdktomcat.interview.google;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
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
}
