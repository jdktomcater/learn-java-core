package com.jdktomcat.pack.dsa.algorithm.leetcode.medium.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int[][] matrix = new int[3][3];
        int row = 0;
        for(List<Integer> rowNums : s){
            int cl = 0;
            for(Integer num:rowNums){
                matrix[row][cl++] = num;
            }
            row++;
        }

        // 8 4
        int sum84 = 0;
        sum84 +=  Math.abs(matrix[0][0]-8);
        sum84 +=  Math.abs(matrix[0][1]-3);
        sum84 +=  Math.abs(matrix[0][2]-4);
        sum84 +=  Math.abs(matrix[1][0]-9);
        sum84 +=  Math.abs(matrix[1][1]-5);
        sum84 +=  Math.abs(matrix[1][2]-1);
        sum84 +=  Math.abs(matrix[2][0]-2);
        sum84 +=  Math.abs(matrix[2][1]-7);
        sum84 +=  Math.abs(matrix[2][2]-6);
        int miniSum = sum84;

        // 8 6
        int sum86 = 0;
        sum86 +=  Math.abs(matrix[0][0]-8);
        sum86 +=  Math.abs(matrix[0][1]-1);
        sum86 +=  Math.abs(matrix[0][2]-6);
        sum86 +=  Math.abs(matrix[1][0]-3);
        sum86 +=  Math.abs(matrix[1][1]-5);
        sum86 +=  Math.abs(matrix[1][2]-7);
        sum86 +=  Math.abs(matrix[2][0]-4);
        sum86 +=  Math.abs(matrix[2][1]-9);
        sum86 +=  Math.abs(matrix[2][2]-2);
        miniSum = Math.min(sum86,miniSum);

        // 4 8
        int sum48 = 0;
        sum48 +=  Math.abs(matrix[0][0]-4);
        sum48 +=  Math.abs(matrix[0][1]-3);
        sum48 +=  Math.abs(matrix[0][2]-8);
        sum48 +=  Math.abs(matrix[1][0]-9);
        sum48 +=  Math.abs(matrix[1][1]-5);
        sum48 +=  Math.abs(matrix[1][2]-1);
        sum48 +=  Math.abs(matrix[2][0]-2);
        sum48 +=  Math.abs(matrix[2][1]-7);
        sum48 +=  Math.abs(matrix[2][2]-6);
        miniSum = Math.min(sum48,miniSum);

        // 4 2
        int sum42 = 0;
        sum42 +=  Math.abs(matrix[0][0]-4);
        sum42 +=  Math.abs(matrix[0][1]-9);
        sum42 +=  Math.abs(matrix[0][2]-2);
        sum42 +=  Math.abs(matrix[1][0]-3);
        sum42 +=  Math.abs(matrix[1][1]-5);
        sum42 +=  Math.abs(matrix[1][2]-7);
        sum42 +=  Math.abs(matrix[2][0]-8);
        sum42 +=  Math.abs(matrix[2][1]-1);
        sum42 +=  Math.abs(matrix[2][2]-6);
        miniSum = Math.min(sum42,miniSum);

        // 6 2
        int sum62 = 0;
        sum62 +=  Math.abs(matrix[0][0]-6);
        sum62 +=  Math.abs(matrix[0][1]-7);
        sum62 +=  Math.abs(matrix[0][2]-2);
        sum62 +=  Math.abs(matrix[1][0]-1);
        sum62 +=  Math.abs(matrix[1][1]-5);
        sum62 +=  Math.abs(matrix[1][2]-9);
        sum62 +=  Math.abs(matrix[2][0]-8);
        sum62 +=  Math.abs(matrix[2][1]-3);
        sum62 +=  Math.abs(matrix[2][2]-4);
        miniSum = Math.min(sum62,miniSum);
        // 6 8
        int sum68 = 0;
        sum68 +=  Math.abs(matrix[0][0]-6);
        sum68 +=  Math.abs(matrix[0][1]-1);
        sum68 +=  Math.abs(matrix[0][2]-8);
        sum68 +=  Math.abs(matrix[1][0]-7);
        sum68 +=  Math.abs(matrix[1][1]-5);
        sum68 +=  Math.abs(matrix[1][2]-3);
        sum68 +=  Math.abs(matrix[2][0]-2);
        sum68 +=  Math.abs(matrix[2][1]-9);
        sum68 +=  Math.abs(matrix[2][2]-4);
        miniSum = Math.min(sum68,miniSum);

        // 2 4
        int sum24 = 0;
        sum24 +=  Math.abs(matrix[0][0]-2);
        sum24 +=  Math.abs(matrix[0][1]-9);
        sum24 +=  Math.abs(matrix[0][2]-4);
        sum24 +=  Math.abs(matrix[1][0]-7);
        sum24 +=  Math.abs(matrix[1][1]-5);
        sum24 +=  Math.abs(matrix[1][2]-3);
        sum24 +=  Math.abs(matrix[2][0]-6);
        sum24 +=  Math.abs(matrix[2][1]-1);
        sum24 +=  Math.abs(matrix[2][2]-8);
        miniSum = Math.min(sum24,miniSum);
        // 2 6
        int sum26 = 0;
        sum26 +=  Math.abs(matrix[0][0]-2);
        sum26 +=  Math.abs(matrix[0][1]-7);
        sum26 +=  Math.abs(matrix[0][2]-6);
        sum26 +=  Math.abs(matrix[1][0]-9);
        sum26 +=  Math.abs(matrix[1][1]-5);
        sum26 +=  Math.abs(matrix[1][2]-1);
        sum26 +=  Math.abs(matrix[2][0]-4);
        sum26 +=  Math.abs(matrix[2][1]-3);
        sum26 +=  Math.abs(matrix[2][2]-8);
        miniSum = Math.min(sum26,miniSum);

        return miniSum;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

