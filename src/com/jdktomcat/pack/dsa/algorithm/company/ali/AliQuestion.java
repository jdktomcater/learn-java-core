package com.jdktomcat.pack.dsa.algorithm.company.ali;

public class AliQuestion {

    public static int minSumSubArray(int[] dataArray, int start, int end) {
        //
        int preEndMinSum = 0;
        int ans = 0;
        for (int i=start; i< end; i++) {
            if (preEndMinSum < 0) {
                preEndMinSum += dataArray[i];
            } else {
                preEndMinSum = dataArray[i];
            }
            ans = Math.min(ans, preEndMinSum);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] dataArray = new int[]{1, -2, 3, -10, 4, 7, 2, 5};
        System.out.println(minSumSubArray(dataArray, 0, dataArray.length));
    }
}
