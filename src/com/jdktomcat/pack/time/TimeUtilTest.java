package com.jdktomcat.pack.time;

import java.util.concurrent.TimeUnit;

public class TimeUtilTest {

    public static void main(String[] args) {
        System.out.println("branch b commit");
        System.out.println("branch c commit");
        System.out.println("branch a commit");
        System.out.println("branch a commit");
        System.out.println(TimeUnit.DAYS.toSeconds(1));
    }

}
