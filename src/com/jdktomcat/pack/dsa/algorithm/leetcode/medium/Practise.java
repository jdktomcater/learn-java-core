package com.jdktomcat.pack.dsa.algorithm.leetcode.medium;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;

public class Practise {

    private static void travel(char[][] grid, int i, int j) {
        if (i > grid.length || j > grid[0].length || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }
        travel(grid, i + 1, j);
        travel(grid, i, j + 1);
        travel(grid, i - 1, j);
        travel(grid, i, j - 1);
        travel(grid, i - 1, j - 1);
        travel(grid, i + 1, j + 1);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    travel(grid, i, j);
                }
            }
        }
        return count;
    }

    public static int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int cur = 0;
            for (int j = 1; j < i; j++) {
                cur = Math.max(cur, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = cur;
        }
        return dp[n];
    }

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int min = Math.min(s.length(), t.length());
        int pos = (s.length() == t.length() ? -1 : min);
        for (int i = 0; i < min; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                pos = i;
                break;
            }
        }
        boolean result = false;
        int cost = pos == -1 ? 0 : s.length() + t.length() - 2 * pos;
        if (cost == k) {
            result = true;
        } else if (cost < k) {
            if ((k - cost) % 2 == 0) {
                result = true;
            } else if (k >= s.length() + t.length()) {
                result = true;
            }
        }

        return result ? "Yes" : "No";
    }

    public static int squares(int a, int b) {
        // Write your code here
        double startSqrt = Math.sqrt(a);
        double startRound = Math.round(startSqrt);
        int start = (int) startRound;
        if (start * start < a) {
            start++;
        }
        double endSqrt = Math.sqrt(b);
        double endFloor = Math.floor(endSqrt);
        int end = (int) endFloor;
        return end - start + 1;

    }


    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Write your code here
        if (y1 > y2) {
            return 10000;
        }
        if (y1 < y2) {
            return 0;
        }
        if(m1 < m2){
            return 0;
        }
        if(m1 == m2 && d1<d2){
            return 0;
        }

        if (d1 == d2 && m1 == m2) {
            return 0;
        }
        if (m1 == m2) {
            return 15 * (d1 - d2);
        }
        return 500 * (m1-m2);

    }


    public static void main(String[] args) {

//        System.out.println(squares(270, 303));
//        System.out.println(libraryFine(5, 5, 2014, 23, 2, 2014));
        System.out.println(Math.round(-1.5));
    }

}
