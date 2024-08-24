package com.jdktomcat.pack.dsa.algorithm.company.bytedance;

public class CountArrangement {

    public static int countArrangement(int n) {
        // dp[state]表示：如state = 11，也就是1011，代表当前使用了第一个数、第二个数、第四个数的情况下，一共有多少个不同的排列
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for(int i = 0; i < (1 << n); i++){
            // 计算已经放的数字个数
            int s = 1;
            for(int j = 0; j < n; j++){
                s += i >> j & 1;// i >> j & 1表示:i的第j位是否是1
            }
            // 放下一个数
            for(int j = 1; j <= n; j++){
                // 没有被选过（对应位置是0）,并且满足互为倍数
                if( (i >> (j-1) & 1) == 0 && (s % j == 0 || j % s == 0)){
                    // 把放j的方案加上
                    // dp[010111] += dp[010101]
                    dp[i | (1 << j - 1)] += dp[i];
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    public static void main(String[] args) {
        int target = 11;
        System.out.println(CountArrangement.countArrangement(target));
    }
}
