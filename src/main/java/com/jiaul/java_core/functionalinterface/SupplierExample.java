package com.jiaul.java_core.functionalinterface;

import java.util.function.Supplier;

public class SupplierExample {

    //Implement Supplier class method
    Supplier<String> supplier = new Supplier<String>() {
        @Override
        public String get() {
            return " this is supplier";
        }
    };

    // Implement Supplier class method by Lambda Expression
    Supplier<String> supplierLambda = () -> "this is supplier with lambda";
}
