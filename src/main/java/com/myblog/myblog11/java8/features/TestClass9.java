package com.myblog.myblog11.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass9 {
    List<String> data= Arrays.asList("mike","stallin","adam");
    List<String> data2 = data.stream().sorted().collect(Collectors.toList());
}
