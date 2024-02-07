package com.myblog.myblog11.java8.features2;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
       List<Employee> employees = Arrays.asList(
               new Employee("mike",30,"chennai"),
               new Employee("adam",25,"chennai"),
               new Employee("stallin",34,"pune"),
               new Employee("sam",34,"bengluru")

               );
       employees.stream().filter(emp->emp.getAge()>30).collect(Collectors.toList());
        for (Employee e : employees) {
            System.out.println(e.getName());
            System.out.println(e.getAge());
            System.out.println(e.getCity());
        }
    }
}