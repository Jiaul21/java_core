package com.jiaul.java_core.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

    // Implement Consumer class method
    public Consumer<String> consumer = new Consumer<String>() {
        @Override
        public void accept(String message) {
            System.out.println("message is: " + message);
        }
    };

    // Implement Consumer class method by Lambda Expression
    public Consumer<String> consumerLambda = message -> System.out.println("message is: " + message);

    // Implement BiConsumer class method by Lambda Expression
    public BiConsumer<String,String> biConsumerLambda = (message1,message2) ->
            System.out.println("message1 is: " + message1+ "message2 is: "+message2);

    // normal methods without return
    public void show(String message) {
        System.out.println("message is: " + message);
    }
}
