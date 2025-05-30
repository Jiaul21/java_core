package com.jiaul.java_core.functionalinterface;

public class Test {

    public static void main(String[] args) {


        ConsumerExample consumerExample=new ConsumerExample();
        consumerExample.show("normal method call");
        consumerExample.consumer.accept("without lambda");
        consumerExample.consumerLambda.accept("lambda");
        consumerExample.biConsumerLambda.accept("first", "second");

        SupplierExample supplierExample=new SupplierExample();
        supplierExample.supplier.get();
        supplierExample.supplierLambda.get();

        FunctionalExample functionalExample=new FunctionalExample();
        int a=functionalExample.function.apply(5);
        int b=functionalExample.functionLambda.apply(10);
        String str=functionalExample.biFunctionLambda.apply(5,10);

        PredicateExample predicateExample= new PredicateExample();
        boolean test = predicateExample.isEven.test(10);
        boolean test2 = predicateExample.isEvenLambda.test(5);
        boolean test3 = predicateExample.isSameLambda.test(10,10);

        CustomExample customExample= new CustomExample();
        String s = customExample.custom.addThree(5, 7, 8);
        Integer s2 = customExample.addThreeLambda.addThree(5, 7, 8);

    }
}
