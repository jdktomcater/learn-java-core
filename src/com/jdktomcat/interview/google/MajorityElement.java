package com.jdktomcat.interview.google;

import java.util.*;

public class MajorityElement {

    public static int majorityElement(final int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("No majority element found");
        }
        if (data.length == 1) {
            return data[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int datum : data) {
            Integer count = map.put(datum, map.getOrDefault(datum, 0) + 1);
            if (count != null && count >= data.length / 2) {
                return datum;
            }
        }
        throw new IllegalArgumentException("No majority element found");
    }

    public static int majorityElement1(final int[] data) {
        Arrays.sort(data);
        int n = data.length;
        return data[n / 2];
    }

    public static int majorityElement3(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static List<Integer> majorityElement2(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;
        for (int i : nums) {
            if (c1 != 0 && a == i){
                c1++;
            } else if (c2 != 0 && b == i) {
                c2++;
            } else if (c1 == 0 && ++c1 >= 0) {
                a = i;
            } else if (c2 == 0 && ++c2 >= 0) {
                b = i;
            }  else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (a == i) {
                c1++;
            } else if (b == i) {
                c2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (c1 > n / 3){
            ans.add(a);
        }
        if (c2 > n / 3){
            ans.add(b);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] data = {2, 1, 2};
        System.out.println(majorityElement3(data));
    }

}

