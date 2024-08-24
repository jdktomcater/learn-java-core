package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数和
 */
public class ThreeNumSum {

    /**
     * 三数和为0列表
     *
     * @param nums 数组
     * @return 三数和为0列表
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    int temp = nums[j];
                    while (j < nums.length - 1 && nums[j] == temp) {
                        j++;
                    }
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            int temp = nums[i];
            while (i < nums.length - 2 && nums[i] == temp && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

}
