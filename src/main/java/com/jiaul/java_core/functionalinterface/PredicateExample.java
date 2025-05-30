package com.jiaul.java_core.functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    // Implement Predicate class
    public Predicate<Integer> isEven = new Predicate<Integer>() {
        @Override
        public boolean test(Integer number) {
            return number % 2 == 0;
        }
    };

    // Implement Predicate class method by Lambda Expression
    public Predicate<Integer> isEvenLambda = number -> number % 2 == 0;


    // Implement BiPredicate class method by Lambda Expression
    public BiPredicate<Integer, Integer> isSameLambda = (number1, number2) -> number1 == number2;
}
