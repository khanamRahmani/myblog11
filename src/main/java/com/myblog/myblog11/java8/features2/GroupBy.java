package com.myblog.myblog11.java8.features2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("mike", 30, "chennai"),
                new Employee("adam", 25, "chennai"),
                new Employee("stallin", 34, "pune"),

                new Employee("sam", 34, "bengluru")

        );
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
        System.out.println(collect);
    }
}