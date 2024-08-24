package com.jdktomcat.pack.dsa.algorithm;

import com.jdktomcat.pack.util.jdk6.HashMap;

import java.util.Map;

public class NumberProblem {
    private static int count(int[] data) {
        Map<Integer, Integer> dataMap = new HashMap<>(data.length);
        Map<Integer, Integer> tempMap = new HashMap<>(data.length);
        for (int target : data) {
            dataMap.put(target, (0 - target));
            tempMap.put(target, (0 - target));
        }
        for (Map.Entry<Integer, Integer> entry : dataMap.entrySet()) {
            if (entry.getKey() != 0 && tempMap.containsKey(entry.getValue())) {
                tempMap.remove(entry.getKey());
            }
        }
        return tempMap.size();
    }
}
