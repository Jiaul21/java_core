package com.jiaul.java_core.streamapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private String name;
    private int age;
    private String address;
    private float salary;
    private List<Mobile> mobiles;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Mobile {
    private String name;
    private int price;
    private String brand;
}
public class PersonDB {
    public static List<Person> getAllPerson(){

        Mobile m1= new Mobile("Galaxy s24",220000,"Samsung");
        Mobile m2= new Mobile("Galaxy s23",200000,"Samsung");
        Mobile m3= new Mobile("Galaxy A20s",20000,"Samsung");
        Mobile m4= new Mobile("IPhone 16",190000,"Apple");
        Mobile m5= new Mobile("IPhone 15",180000,"Apple");
        Mobile m6= new Mobile("IPhone 14",170000,"Apple");

        Person p1= new Person("name 1",25,"dhaka",20000,List.of(m3));
        Person p2= new Person("name 2",30,"rangpur",40000,List.of(m1,m4));
        Person p3= new Person("name 3",20,"dinajpur",25000,List.of(m6));
        Person p4= new Person("name 4",18,"dhaka",18000,List.of(m3));
        Person p5= new Person("name 5",28,"moymonshing",45000,List.of(m5));
        Person p6= new Person("name 6",35,"rangpur",50000,List.of(m2,m6));
        Person p7= new Person("name 7",27,"dhaka",40000,List.of(m2));
        Person p8= new Person("name 8",32,"rangpur",50000,List.of(m2,m5));
        Person p9= new Person("name 9",40,"gajipur",60000,List.of(m1,m2,m4,m5));
        Person p10= new Person("name 10",22,"dhaka",28000,List.of(m5));

        return List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
    }
}
