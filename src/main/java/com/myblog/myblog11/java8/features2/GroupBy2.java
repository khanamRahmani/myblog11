package com.myblog.myblog11.java8.features2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("mike", 30, "chennai"),
                new Employee("adam", 25, "chennai"),
                new Employee("stallin", 34, "pune"),

                new Employee("sam", 34, "bengluru")

        );
        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));
        for(Employee employee:employees)
        {
            System.out.println(collect.get(employee.getAge()));//based on the key getting obj adresses
    }

    }
}
