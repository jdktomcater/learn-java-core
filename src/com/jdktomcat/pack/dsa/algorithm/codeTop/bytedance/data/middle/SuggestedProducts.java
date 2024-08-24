package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 搜索推荐系统
 */
public class SuggestedProducts {

    /**
     * 搜索推荐系统
     *
     * @param products   数组
     * @param searchWord 目标字符串
     * @return 结果列表
     */
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // 先排序
        Arrays.sort(products);
        // 结果
        List<List<String>> ans = new ArrayList<>();
        // 左右指针
        int left = 0, right = products.length;
        // 遍历目标字符串
        for (int i = 0; i < searchWord.length(); i++) {
            // 左指针移动逻辑
            while (left < right && (products[left].length() <= i || products[left].charAt(i) < searchWord.charAt(i))) {
                left++;
            }
            // 右指针移动逻辑
            while (left < right && products[right - 1].length() > i && products[right - 1].charAt(i) > searchWord.charAt(i)) {
                right--;
            }
            List<String> curr = new ArrayList<>();
            // 最多3个字符串
            for (int j = left; j < right && j < left + 3; j++) {
                curr.add(products[j]);
            }
            ans.add(curr);
        }
        return ans;
    }
}
