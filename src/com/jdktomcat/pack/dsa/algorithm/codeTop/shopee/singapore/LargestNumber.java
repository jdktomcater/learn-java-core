package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 最大数
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num + "");
        }
        list.sort((o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str2.compareTo(str1);
        });
        StringBuilder res = new StringBuilder();
        for (String str : list) {
            res.append(str);
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();
    }
}
