package com.jiaul.java_core.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalExample {

    // Implement Function class method
    public Function<Integer, Integer> function = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer integer) {
            return integer + 10;
        }
    };

    // Implement Function class method by Lambda Expression
    public Function<Integer, Integer> functionLambda = number -> number + 10;

    // Implement BiFunction class method by Lambda Expression
    public BiFunction<Integer, Integer, String> biFunctionLambda = (number1, number2) -> String.valueOf(number1 + number2);
}
