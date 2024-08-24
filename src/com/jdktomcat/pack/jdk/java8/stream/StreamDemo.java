package com.jdktomcat.pack.jdk.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 430, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<String> threeHighCaloricDishNames = menu.stream().
                filter(d -> {
                    System.out.println("filter " + d.getName());
                    return d.getCalories() > 300;
                }).map(d -> {
            System.out.println("map " + d.getName());
            return d.getName();
        }).limit(3).collect(Collectors.toList());
        System.out.println(Arrays.toString(threeHighCaloricDishNames.toArray()));
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<int[]> pairs = number1.stream().flatMap(num1 -> number2.stream().map(num2 -> new int[]{num1, num2})).collect(Collectors.toList());
        System.out.println(pairs);

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(20).forEach(t -> System.out.println("" + t[0] + "," + t[1] + ")"));


    }
}
