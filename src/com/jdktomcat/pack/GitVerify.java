package com.jdktomcat.pack;

/**
 * @author Timmy
 * @version V1.0
 * @description 类描述
 * @date 2023/9/3 10:15
 */
public class GitVerify {
    public static void main(String[] args) {
        String tag = "cycle_wo";
        String cycle = "cycle_";
        tag = tag.substring(tag.indexOf(cycle)+ cycle.length());
        System.out.println(tag);
    }

}
