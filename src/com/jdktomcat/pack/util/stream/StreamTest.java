package com.jdktomcat.pack.util.stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2018-11-23
 */
public class StreamTest {

    public static void main(String[] args) {
//        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
//        IntStream.range(1, 3).forEach(System.out::println);
//        IntStream.rangeClosed(1, 3).forEach(System.out::println);
//
//
//        IntStream.of(1,2,3,4,5,6,7,8,9,10).forEach(System.out::println);
//        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
//        System.out.println(nums.parallelStream().allMatch(predicate -> predicate % 3 == 0));
//        List<Integer> squareNums = nums.stream().map(n -> n * n).collect(Collectors.toList());
//        System.out.println(Arrays.toString(squareNums.toArray()));

//        Stream<List<Integer>> inputStream = Stream.of(
//                Arrays.asList(1),
//                Arrays.asList(2, 3),
//                Arrays.asList(4, 5, 6)
//        );
//        inputStream.flatMap((childList) -> childList.stream()).forEach(System.out::println);
//
//        // 字符串连接，concat = "ABCD"
//        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
//        System.out.println(concat);
//        // 求最小值，minValue = -3.0
//        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
//        System.out.println(minValue);
//        // 求和，sumValue = 10, 有起始值
//        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
//        System.out.println(sumValue);
//        // 求和，sumValue = 10, 无起始值
//        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
//        System.out.println(sumValue);
//        // 过滤，字符串连接，concat = "ace"
//        concat = Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
//        System.out.println(concat);


        Map<String,String> dataMap = new HashMap<>();
        dataMap.put("1","1");
        dataMap.put("2","2");
        dataMap.put("3","3");
        dataMap.put("4","4");
        dataMap.forEach((key,value)->{
            dataMap.put(key,"1234");
        });
        System.out.println(dataMap);
    }
}
