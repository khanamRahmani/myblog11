package com.myblog.myblog11.java8.features2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GruopBy3 {
    public static void main(String[] args) {
            List<Employee> employees = Arrays.asList(
                    new Employee("mike", 30, "chennai"),
                    new Employee("adam", 25, "chennai"),
                    new Employee("stallin", 34, "pune"),

                    new Employee("sam", 34, "bengluru")

            );
//            Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));
//            for(Map.Entry<Integer,List<Employee>>entry:collect.entrySet()){
//                int age=entry.getKey();
//                List<Employee>employeesWithAge=entry.getValue();
//                System.out.println("age:"+age+"----");
//                for(Employee e:employeesWithAge){
//                    System.out.println(e.getCity());
//                    System.out.println(e.getName());
//                }
                Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
                for(Map.Entry<String,List<Employee>>entry:collect.entrySet()){
                    String city =entry.getKey();
                    List<Employee>employeesWithAge=entry.getValue();
                    System.out.println("city:"+city+"----");
                    for(Employee e:employeesWithAge){
                        System.out.println(e.getAge());
                        System.out.println(e.getName());
                    }


            }

    }
}
