package com.jiaul.java_core.compare;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Data
@AllArgsConstructor
class Product2 implements Comparable<Product2> {
    Long id;
    String name;
    double price;
    int quantity;

    @Override
    public int compareTo(Product2 other) {
        return Double.compare(this.price, other.price); // Natural order: price low to high
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Product2> products =  new ArrayList<>(List.of(
                new Product2(3L, "Monitor", 150.0, 10),
                new Product2(1L, "Keyboard", 30.0, 20),
                new Product2(2L, "Mouse", 25.0, 50)
        ));

        // Sort using natural order (compareTo)
        Collections.sort(products);

        products.forEach(System.out::println);


    }
}
