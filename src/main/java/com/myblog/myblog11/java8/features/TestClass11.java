package com.myblog.myblog11.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TestClass11 {
    public static <integer> void main(String[] args) {
        List<Integer> data= Arrays.asList(15,3,60,100,1,15,100);
        List<integer>newData= (List<integer>) data.stream().distinct().collect(Collectors.toList());
        System.out.println(newData);
    }
}
