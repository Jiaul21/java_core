package com.jiaul.java_core.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        List<Person> personList = PersonDB.getAllPerson();


        Stream<Person> personStream=personList.stream();
        personStream.forEach(System.out::println);
        // personStream.forEach(System.out::println); // will throw exception because stream data can be used or consumed once


         /******************* 1. forEach(Consumer) *******************/
//        personList.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));
//        personList.forEach(System.out::println);    // printing each object directly
//        personList.forEach(person -> person.setAddress("khulna"));  // set values to all

         /******************* 2. filter(Predicate) *******************/
        List<Person> people=personList.stream()
                .filter(person -> person.getAge()>25 && person.getSalary()>40000)
                .toList();

         /******************* 3. collect( collector) *******************/
        List<Person> people1=  personList.stream()
                .filter(person -> person.getAge()>22)
                .collect(Collectors.toList());

        Set<Person> people2=  personList.stream()
                .filter(person -> person.getAge()>22)
                .collect(Collectors.toSet());

        List<Person> people3= personList.stream()
                .filter(person -> person.getAge()>22)
                .collect(Collectors.toList());

        List<Person> name=personList.stream()
                .filter(person -> person.getAge()>22)
                .toList();       // directly get immutable list

        Object[] name2= personList.stream()
                .map(Person::getName)
                .toArray();     // get array of Object

        System.out.println();

         /******************* 4. map(Function) *******************
         return single elements like data, list of data etc*/
        List<String> address=personList.stream()
                .map(Person::getAddress)    //.map(person -> person.getAddress())
                .collect(Collectors.toList());

        List<String> address2=personList.stream()
                .map(Person::getAddress)    //.map(person -> person.getAddress())
                .distinct()     // give unique only
                .collect(Collectors.toList());

        List<String> address3=personList.stream()
                .filter(person -> person.getAge()>22)
                .map(Person::getAddress)
                .collect(Collectors.toList());

         /******************* 5. flatMap(Function) *******************
         used for collection of collection*/
        List<String> brand=personList.stream()
                .flatMap(person -> person.getMobiles()
                        .stream())
                .map(Mobile::getBrand).distinct()
                .collect(Collectors.toList());

        List<String> brand2 = personList.stream()
                .flatMap(person -> person.getMobiles()
                        .stream())
                .filter(mobile -> mobile.getPrice()>=190000)
                .map(Mobile::getBrand).distinct()
                .collect(Collectors.toList());

        List<Mobile> mobiles = personList.stream()
                .flatMap(person -> person.getMobiles()
                        .stream())
                .filter(mobile -> mobile.getPrice()>=190000)
                .collect(Collectors.toList());

         /******************* 6. sorted(compare with) asc/desc *******************/
        List<Person> people4 = personList.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        List<Person> people5 = personList.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Person::getAge)))
                .collect(Collectors.toList());

         /******************* 7. max(compare with)/min(compare with) *******************/
        Optional<Person> people6 = personList.stream()
                .max(Comparator.comparing(Person::getSalary));

        Optional<String> salary = personList.stream()
                .max(Comparator.comparing(Person::getSalary))
                .map(Person::getName);

         /******************* 8. groupingBy(Function) *******************/
        Map<String, List<Person>> people7 = personList.stream()
                .collect(Collectors.groupingBy(Person::getAddress));        // group of Person based on address

         /******************* 9. groupingBy(mapping()) *******************/
        Map<String, List<String>> people8 = personList.stream()
                .collect(Collectors.groupingBy(Person::getAddress,
                        Collectors.mapping(Person::getName,
                                Collectors.toList())));

         /******************* 10. groupingBy(counting()) *******************/
        Map<String, Long> people9 = personList.stream()
                .collect(Collectors.groupingBy(Person::getAddress,
                        Collectors.counting()));

         /******************* 11. findFirst() *******************/
        Person people10 = personList.stream()
                .filter(e -> e.getAddress().equals("dhaka"))
                .findFirst()    // return 1st element
                .orElseThrow(()->new IllegalArgumentException("Person not found "));//.orElse(new Person())

         /******************* 12. findAny() *******************/
        Person people11 = personList.stream()
                .filter(e -> e.getAddress().equals("dhaka"))
                .findAny()      // return any element during parallel streaming
                .orElseThrow(()->new IllegalArgumentException("Person not found "));

         /******************* 13. anyMatch(Predicate) *******************/
        boolean b=personList.stream()
                .anyMatch(person -> person.getAddress().equals("dhaka"));

         /******************* 14. allMatch(Predicate) *******************/
        boolean b2=personList.stream()
                .allMatch(person -> person.getAge()>20);

         /******************* 15. noneMatch(Predicate) *******************/
        boolean b3=personList.stream()
                .noneMatch(person -> person.getAge()==21);

         /******************* 16. limit(max limit) *******************/
        List<String> people12 = personList.stream()
                .map(Person::getName)
                .limit(5)
                .collect(Collectors.toList());

        /******************* 17. skip(number) *******************/
        personList.stream()
                .map(Person::getName)
                .skip(5)
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
