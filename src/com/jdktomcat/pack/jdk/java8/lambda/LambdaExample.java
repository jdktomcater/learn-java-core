package com.jdktomcat.pack.jdk.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 类描述：Lambda表达式示例
 *
 * @author 汤旗
 * @date 2019-05-20 15:20
 */
public class LambdaExample {

    private static void old() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        System.out.println(Arrays.toString(names.toArray()));
    }

    private static void lambda() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        System.out.println(Arrays.toString(names.toArray()));
    }

    private static void lambdaMore() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort((String a, String b) -> b.compareTo(a));
        System.out.println(Arrays.toString(names.toArray()));
    }

    public static void main(String[] args) {
        old();
        lambda();
        lambdaMore();
    }
}
