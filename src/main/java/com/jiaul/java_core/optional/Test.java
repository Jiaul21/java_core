package com.jiaul.java_core.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {

        String s1 = "non empty string";
        String s2 = null;

        /*
         1. public static <T> Optional<T> empty()
            - is static method
            - return empty Optional
         */
        Optional<String> str = Optional.empty();
        System.out.println(str);        // Optional.empty

        /*
        2. public static <T> Optional<T> of(T value)
           - static method.
           - Return Optional.
           - Object must be not null otherwise throw NullPointerException
         */
//        Optional.of(s1);    // NullPointerException
        Optional.of(s1);

        /*
        3. public static <T> Optional<T> ofNullable(T value)
           - static method.
           - Return Optional.
           - if object is null it return empty Optional
         */
        Optional.ofNullable(s2);      // return empty Optional
        Optional.ofNullable(s1);      // return Optional with value


        /*
        3. public boolean isPresent()
        4. public boolean isEmpty()
           - Return true or false
         */
        Optional<String> str1 = Optional.empty();
        System.out.println(str1.isPresent());   // false
        System.out.println(str1.isEmpty());     // true


        /*
        5. public T get()
           - If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException.
         */
        Optional.of("new string").get();        // return String value
        Optional.of(null).get();                // throw NullPointerException
        Optional.ofNullable(null).get();        // throw NullPointerException

        /*
        6. public void ifPresent(Consumer<? super T> consumer)
           - If a value is present, invoke the specified consumer with the value, otherwise do nothing.
         */
        Optional<String> opt = Optional.ofNullable(null);
        opt.ifPresent(obj -> System.out.println(obj));



        /*
        7. public T orElse(T other)
           - value will return if present
           - other the value to be returned if there is no value present in optional,
           - it could be null, method call or direct value
           - if optional value present other value or method (which method return value) will invoke but other value do not return
         */
        Optional.ofNullable(s2).orElse("john");   // "jhon" will return
        Optional.ofNullable(s2).orElse(null);     // null will return
        Optional.ofNullable(s2).orElse(getName());     // return the return value of method


        /*
        8. public T orElseGet(Supplier<? extends T> other)
           - value will return if present
           - other the value to be returned if there is no value present in optional,
           - it could be null, method call or direct value
           - if optional value present other value or method (which method return value) will not invoke
         */
        String name = null;
        Optional.ofNullable(s2).orElseGet(() -> "max");   // "max" will return
        Optional.ofNullable(s2).orElseGet(() -> null);     // null will return
        Optional.ofNullable(s2).orElseGet(() -> getName());     // return the return value of method
        Optional.ofNullable(s2).orElseGet(() -> {
            // some code
            return "max";
        });

        /*
        9. public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X
           - Return the contained value, if present, otherwise throw an exception to be created by the provided supplier.
         */
        Optional.ofNullable(s1).orElseThrow();      // Default NoSuchElementException
        Optional.ofNullable(s1).orElseThrow(RuntimeException::new);     // Throws custom Exception
        Optional.ofNullable(s1).orElseThrow(() -> {
            // some code
            return new RuntimeException();
        });


        /*
        10. public Optional<T> filter(Predicate<? super T> predicate)
           - If a value is present, and the value matches the given predicate, return an Optional result,
           - otherwise return an empty Optional.
           - used in One Optional value not like stream api filter used for list of element
         */
        Optional<User> optionalUser = Optional.of(new User("Alice", true));
        Optional<User> name2 = optionalUser.filter(User::isActive);


        /*
        11. public <U> Optional<U> map(Function<? super T,? extends U> mapper)
           - If a value is present, apply the provided mapping function and return an Optional result
           - otherwise return an empty Optional.
           - used in One Optional value not like stream api map used for list of element
         */

        Optional<String> optional = Optional.of(new User("Alice", true))
                .filter(User::isActive)
                .map(user -> user.getName());       // value automatically wrap with Optional


        /*
        11. public <U> Optional<U> flatMap(Function<? super T,Optional<U>> mapper)
           - If a value is present, apply the provided Optional-bearing mapping function to it, return that result, otherwise return an empty Optional.
           - otherwise return an empty Optional.
           - This method is similar to map(Function), but the provided mapper is one whose result is already an Optional,
           - and if invoked, flatMap does not wrap it with an additional Optional.
           - used in One Optional value not like stream api map used for list of element
         */

        Optional<String> optional2 = Optional.of(new User("Alice", true))
                .filter(User::isActive)
                .flatMap(user -> Optional.ofNullable(user.getName()));      // need manually wrap with Optional


    }

    public static String getName() {
        return "jhon";
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private boolean active;
}