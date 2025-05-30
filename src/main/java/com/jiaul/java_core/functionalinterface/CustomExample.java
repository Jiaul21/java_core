package com.jiaul.java_core.functionalinterface;

public class CustomExample {

    // Implement Custom Functional Interface that take 3 Input and 1 output
    Custom<Integer, Integer, Integer, String> custom=new Custom<Integer, Integer, Integer, String>() {
        @Override
        public String addThree(Integer integer, Integer integer2, Integer integer3) {
            return String.valueOf(integer+integer2+integer3);
        }
    };

    // Implement Custom Functional Interface that take 3 Input and 1 output by Lambda Expression
    Custom<Integer, Integer, Integer, Integer> addThreeLambda = ((integer, integer2, integer3) -> integer+integer2+integer3);
}
