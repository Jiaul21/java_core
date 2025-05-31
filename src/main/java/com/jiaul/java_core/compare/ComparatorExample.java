package com.jiaul.java_core.compare;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
class Product {
    Long id;
    String name;
    double price;
    int quantity;
}


public class ComparatorExample {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product(3L, "Monitor", 150.0, 10),
                new Product(1L, "Keyboard", 30.0, 20),
                new Product(2L, "Mouse", 25.0, 50),
                new Product(4L, "Monitor", 120.0, 5)
        ));

        // 1. Using compare() with custom logic
        products.sort((p1, p2) -> {
            if (p1 == null || p2 == null) return 0;
            return Integer.compare(p1.getQuantity(), p2.getQuantity());
        });

        // 2. comparing()
        products.sort(Comparator.comparing(Product::getName));

        // 3. comparingDouble()
        products.sort(Comparator.comparingDouble(Product::getPrice));

        // 4. comparingInt()
        products.sort(Comparator.comparingInt(Product::getQuantity));

        // 5. comparingLong()
        products.sort(Comparator.comparingLong(Product::getId));

        // 6. reversed()
        products.sort(Comparator.comparing(Product::getPrice).reversed());

        // 7. thenComparing()
        // compare based on price(descending) then name(ascending)
        products.sort(
                Comparator.comparing(Product::getPrice).reversed()
                        .thenComparing(Product::getName)
        );

        products.add(null);

        // 8. nullsFirst()
        // when list may have null element
        products.sort(Comparator.nullsFirst(Comparator.comparing(Product::getName)));
        System.out.println("null first");
        products.forEach(System.out::println);

        // 6. nullsLast()
        // when list may have null element
        products.sort(Comparator.nullsLast(Comparator.comparing(Product::getPrice)));
        System.out.println("null last");
        products.forEach(System.out::println);


        List<String> names = Arrays.asList("Monitor", "Keyboard", "Mouse");

        // 7. naturalOrder() on those object who have Comparable method in class
        names.sort(Comparator.naturalOrder());

        // 8. reverseOrder() on those object who have Comparable method in class
        names.sort(Comparator.reverseOrder());


    }

}