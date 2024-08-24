package com.jdktomcat.pack.dsa.algorithm.company.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 类描述：随机数问题
 *
 * @author 汤旗
 * @date 2019-08-12 16:23
 */
public class RandomProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i = 0 ; i < num ;i++){
                int curr = scanner.nextInt();
                set.add(curr);
            }
            for(Integer i : set){
                System.out.println(i);
            }
        }
    }
}
