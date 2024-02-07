package com.myblog.myblog11;



public class TestClass {
    public static void main(String[] args) {
        TestClass t = new TestClass();
        int val = t.test();
        System.out.println(val);

    }
    public int  test(){
        int otp=SampleTest.test1();
     return otp;
    }
}
