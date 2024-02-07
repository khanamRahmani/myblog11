package com.myblog.myblog11.java8.features2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Square {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(10,12,6,5,7,8,9);
        List<Integer>data=numbers.stream().filter(n1->n1%2==0).map(n2->n2*n2).collect(Collectors.toList());
        System.out.println(data);


    }
}
