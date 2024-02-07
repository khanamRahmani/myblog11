package com.myblog.myblog11.java8.features;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.function.Function;

import static javax.swing.SpringLayout.SOUTH;

public class TestClass1 {
    public static void main(String[] args) {
        Function<String,Integer> result= str->str.length();
        Integer val=result.apply("mike");
        System.out.println(val);
    }

}
