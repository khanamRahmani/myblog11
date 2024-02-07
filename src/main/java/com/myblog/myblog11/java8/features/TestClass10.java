package com.myblog.myblog11.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass10 {
    public static void main(String[] args) {
        List<Integer> data= Arrays.asList(15,3,60,100,1);
        List<Integer> newData=data.stream().sorted().collect(Collectors.toList());
        System.out.println(newData);
    }
}
