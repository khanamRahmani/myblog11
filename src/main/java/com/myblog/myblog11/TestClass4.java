package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass4 {
    public static void main(String[] args) {
        List<String> num = Arrays.asList("mike", "adam", "mike", "Stallin");
        List<String> starts = num.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        System.out.println(starts);
        List<String> ends = num.stream().filter(s -> s.endsWith("n")).collect(Collectors.toList());
        System.out.println(ends);


    }
}