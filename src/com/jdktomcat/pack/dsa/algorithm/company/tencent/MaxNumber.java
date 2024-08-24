package com.jdktomcat.pack.dsa.algorithm.company.tencent;

import java.util.Random;

public class MaxNumber {

    public static int maxNum(int[] data, int startIndex, int endIndex) {
        int length = endIndex - startIndex;
        int midIndex = startIndex + length / 2;
        int targetNum = data[midIndex];
        if (midIndex != 0) {
            int leftNum = data[midIndex - 1];
            int rightNum = data[midIndex + 1];
            if (leftNum < targetNum && rightNum >= targetNum) {
                return maxNum(data, startIndex, midIndex);
            } else if (leftNum < targetNum && rightNum < targetNum) {
                return midIndex;
            } else if (leftNum > targetNum && rightNum <= targetNum) {
                return maxNum(data, midIndex + 1, endIndex);
            }
        }
        return -1;
    }

    public static int rand11() {
        return new Random().nextInt(10);
    }

    public static int rand100() {
//        return (rand11() * rand11()) % 100;
        int firstNum = rand11() % 10;
        int secondNum = rand11() % 10;
        if (firstNum == 0) {
            return secondNum;
        } else if (secondNum != 0) {
            return firstNum * 10 + secondNum;
        }
        return 0;
    }


    public static void main(String[] args) {

    }
}
