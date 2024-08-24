package com.jdktomcat.pack.dsa.algorithm.company.bytedance;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String target) {
        int maxSubLength = 0;
        if (target != null && target.length() == 0) {
            int leftIndex = 0;
            int rightIndex = 1;
            for (int index = 1; index < target.length(); index++) {
                int subIndex = target.substring(leftIndex, rightIndex).indexOf(target.charAt(index));
                if (subIndex == -1) {
                    rightIndex = index + 1;
                } else {
                    maxSubLength = subIndex + 1;
                    leftIndex += subIndex;
                }
            }
            if(maxSubLength <  rightIndex - leftIndex){
                maxSubLength = rightIndex - leftIndex;
            }
        }
        return maxSubLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
