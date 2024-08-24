package com.jdktomcat.interview.dx;

import java.util.HashMap;
import java.util.Map;

public class NumberProblem {

    public static int maxIncreaseSub(int[] numbers) {
        Map<Integer, Boolean> dataMap = new HashMap<>();
        for (int number : numbers) {
            dataMap.put(number, true);
        }
        int max = 0;
        for (int number : numbers) {
            int it = number + 1;
            while (dataMap.containsKey(it)) {
                dataMap.remove(it);
                it++;
            }
            int ij = number - 1;
            while (dataMap.containsKey(ij)) {
                dataMap.remove(ij);
                ij--;
            }
            max = Math.max(max, it - ij - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {100, 4, 200, 1, 3, 2};
        System.out.println(maxIncreaseSub(numbers));
    }

}
