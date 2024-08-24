package com.jdktomcat.pack.dsa.algorithm.leetcode.d20220505;

import java.util.*;

/**
 * 类概述：
 *
 * @author tangqi
 * @date 2022-05-05
 */
public class D20220505Practise {

    private static List<Integer> makeListData(int numLeft, int numMid, int numRight) {
        List<Integer> dataList = new ArrayList<>();
        dataList.add(numLeft);
        dataList.add(numMid);
        dataList.add(numRight);
        return dataList;
    }

    private static List<Integer> makeListData(int[] nums, int leftIndex, int midIndex, int rightIndex) {
        List<Integer> dataList = new ArrayList<>();
        dataList.add(nums[leftIndex]);
        dataList.add(nums[midIndex]);
        dataList.add(nums[rightIndex]);
        return dataList;
    }

    public static List<List<Integer>> threeSum(int[] nums, int left, int right, int zero) {
        List<List<Integer>> dataList = new ArrayList<>();
        if (nums[left] + nums[right] == 0 && zero != -1) {
            dataList.add(makeListData(nums, left, zero, right));
        }
        return dataList;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> dataList = new ArrayList<>();
        if (nums.length < 3) {
            return dataList;
        }
        Arrays.sort(nums);
        int left = -1, right = -1, zero = -1;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > 0) {
                if (right == -1) {
                    right = index;
                }
            } else if (nums[index] == 0) {
                if (zero == -1) {
                    zero = index;
                }
            } else {
                left = index;
            }
        }
        dataList.addAll(threeSum(nums, left, right, zero));
        return dataList;
    }

    public static List<Integer> handle(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (Integer num : ranked) {
            if (deque.peek() == null || !deque.peek().equals(num)) {
                deque.push(num);
            }
        }
        for (Integer num : player) {
            Integer top = deque.peek();
            while (top != null && num > top) {
                deque.poll();
                top = deque.peek();
            }
            if (top != null) {
                result.add(num < top ? deque.size() + 1 : deque.size());
            } else {
                result.add(1);
            }
        }
        return result;
    }

    public static  void main(String[] args) {
        int[] nums = new int[]{295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4};
        List<Integer> ranked = new ArrayList<>();
        for(int num:nums){
            ranked.add(num);
        }
        int[] playNums = new int[]{5,5,6,14,19,20,23,25,29,29,30,30,32,37,38,38,38,41,41,44,45,45,47,59,59,62,63,65,67,69,70,72,72,76,79,82,83,90,91,92,93,98,98,100,100,102,103,105,106,107,109,112,115,118,118,121,122,122,123,125,125,125,127,128,131,131,133,134,139,140,141,143,144,144,144,144,147,150,152,155,156,160,164,164,165,165,166,168,169,170,171,172,173,174,174,180,184,187,187,188,194,197,197,197,198,201,202,202,207,208,211,212,212,214,217,219,219,220,220,223,225,227,228,229,229,233,235,235,236,242,242,245,246,252,253,253,257,257,260,261,266,266,268,269,271,271,275,276,281,282,283,284,285,287,289,289,295,296,298,300,300,301,304,306,308,309,310,316,318,318,324,326,329,329,329,330,330,332,337,337,341,341,349,351,351,354,356,357,366,369,377,379,380,382,391,391,394,396,396,400};
        List<Integer> play = new ArrayList<>();
        for(int num:playNums){
            play.add(num);
        }
        System.out.println(handle(ranked,play));
    }

}
