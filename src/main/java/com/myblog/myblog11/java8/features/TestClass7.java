package com.myblog.myblog11.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass7 {
    public static void main(String[] args) {
        List<Integer> data= Arrays.asList(10,20,30,60,90);
        List<Integer>newNumbers= data.stream().map(i->i+10).collect(Collectors.toList());
        System.out.println(newNumbers);
    }
}
