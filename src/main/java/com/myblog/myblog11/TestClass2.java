package com.myblog.myblog11;

import java.sql.SQLOutput;
import java.util.function.Predicate;

public class TestClass2 {
    public static void main(String[] args) {
        Predicate<String> val= str->str.equals("mike");
        boolean result=val.test("Stallin");
        System.out.println(result);
    }
}
