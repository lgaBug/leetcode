package com.lga.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppleServer {

    private static List<Apple> appleStore = new ArrayList<>();

    static {
        appleStore.add(new Apple(1, "red", 500, "湖南"));
        appleStore.add(new Apple(2, "red", 400, "湖南"));
        appleStore.add(new Apple(3, "green", 300, "湖南"));
        appleStore.add(new Apple(4, "green", 200, "天津"));
        appleStore.add(new Apple(5, "green", 100, "天津"));

    }


    /**
     * 找出红色的苹果
     *
     * 过滤颜色
     */
    @Test
    public void test1() {
        final List<Apple> list = appleStore.stream()
                .filter(a -> a.getColor().equals("red"))
                .collect(Collectors.toList());
        System.out.println("list = " + list);
    }


    @Test
    public void test2() {
        final List<Apple> list = appleStore.stream()
                .filter(a -> a.getColor().equals("red"))
                .filter(a -> a.getWeight() > 400)
                .collect(Collectors.toList());
        System.out.println("list = " + list);
    }


    public void test3(Predicate<? super Apple> pr) {
        final List<Apple> list = appleStore.stream()
                .filter(pr)
                .collect(Collectors.toList());
        System.out.println("list = " + list);
    }


    /**
     * 统计分组
     * 求每个颜色的平均重量
     */
    @Test
    public void test4() {

        final Map<String, Double> collect = appleStore.stream().collect(
                Collectors.groupingBy(a -> a.getColor(), Collectors.averagingInt(a -> a.getWeight())));
        System.out.println("collect = " + collect);
    }


    /**
     * 产生流的方式
     */
    public void test5() {
        appleStore.stream();
        Arrays.stream(new int[]{1,2,3});
        Stream.of(1, 2, 3);
    }


    @Test
    public void test7() {
        appleStore.stream().filter(a -> a.getColor().equals("red") || a.getColor().equals("green"))
                .map(Apple::getColor)
                .distinct()
                .peek(color -> System.out.println(color))
                .toArray();

    }

    public static void main(String[] args) {
        new AppleServer().test3(a -> a.getColor().equals("green"));
    }


    @Test

    public void test8() {

        Stream.of(1, 23, 4, 5, 7, 9).filter(num -> num > 4).toArray();
    }


    /**
     * collect：采集
     * 1. list
     * 2. map
     * 3. group by
     * 4. 数组
     * 5. 求最大值
     * 6. 求平均值
     */
    @Test
    public void test9() {
        final Map<Integer, Apple> collect = appleStore.stream().collect(Collectors.toMap(a -> a.getId(), a -> a));
        System.out.println("collect = " + collect);
    }













    @Data
    @AllArgsConstructor
    private static class Apple {
        private int id;
        private String color;
        private int weight;
        private String origin;
    }
}
