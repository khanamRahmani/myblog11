package com.myblog.myblog11.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass8 {
    public static void main(String[] args) {
        List<String> data= Arrays.asList("mike","stallin","adam");
        List<String>newData=data.stream().map(i->i.toUpperCase()).collect(Collectors.toList());

        List<String> data2= Arrays.asList("ROSE","SHAHIN","AHMAD");
        List<String>newData2=data2.stream().map(i->i.toLowerCase()).collect(Collectors.toList());

        System.out.println(newData);
        System.out.println(newData2);
    }
}
