package com.jiaul.java_core.functionalinterface;

@FunctionalInterface
public interface Custom<U, V, W, T> {

    // total only 1  abstract method is allowed in functional interface

     T addThree(U u, V v, W w);


    //object class abstract methods is allowed
    int hashCode();
    String toString();
    boolean equals(Object obj);
}
