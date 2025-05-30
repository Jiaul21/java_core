package com.jiaul.java_core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

interface C {

}

class B {

}

class A extends B implements C {

    public int var1 = 10;
    protected int var2 = 10;
    int var4 = 10;
    private int var3 = 10;

    public static int s=20;


    A() {
        System.out.println("constructor A default");
    }

    public A(int a) {
        System.out.println("constructor A public");
    }

    protected A(int a, int b) {
        System.out.println("constructor A default");
    }

    private A(int a, int b, int c) {
        System.out.println("constructor A default");
    }

    public void fun1(int a) {
        System.out.println("class A public");
    }

    protected void fun2() {
        System.out.println("class A protected");
    }

    private void fun3() {
        System.out.println("class A private");
    }

    void fun4() {
        System.out.println("class A default");
    }
    public static void fun5() {
        System.out.println("class A default");
    }
}

public class ClassExample {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {


        Class c = Class.forName("com.jiaul.web_socket.reflection.A");       // package is required

        System.out.println("c.getName():----- " + c.getName());      //com.jiaul.web_socket.reflection.A
        System.out.println("c.getCanonicalName():----- " + c.getCanonicalName());        //com.jiaul.web_socket.reflection.A
        System.out.println("c.getPackageName():----- " + c.getPackageName());        //com.jiaul.web_socket.reflection
        System.out.println("c.getTypeName():----- " + c.getTypeName());      //com.jiaul.web_socket.reflection.A
        System.out.println("c.getSimpleName():----- " + c.getSimpleName());      // A
        System.out.println("c.getSuperclass().getName():----- " + c.getSuperclass().getName());      //com.jiaul.web_socket.reflection.B
        System.out.println("c.isAnnotation():----- " + c.isAnnotation());       // false
        System.out.println("c.isArray():----- " + c.isArray());       // false
        System.out.println("c.isEnum():----- " + c.isEnum());       // false
        System.out.println("c.isAnonymousClass():----- " + c.isAnonymousClass());       // false
        System.out.println("c.isInterface():----- " + c.isInterface());       // false
        System.out.println("c.isRecord():----- " + c.isRecord());       // false

        System.out.println("******************* Constructor **********************\n");

        Constructor constructor = c.getDeclaredConstructor(int.class);  // any type constructor
        Constructor constructor2 = c.getDeclaredConstructor();  // default
        System.out.println("constructor1 :------ " + constructor);

        Constructor[] constructors1 = c.getConstructors();   // return public only
        System.out.println("Constructors:----------------------------------------------- ");
        for (Constructor cons : constructors1) {
            System.out.println(cons);
        }

        Constructor[] constructors2 = c.getDeclaredConstructors();   // return public only
        System.out.println("All Constructors:----------------------------------------------- ");
        for (Constructor cons : constructors2) {
            System.out.println(cons);
        }

        System.out.println("******************* Field **********************\n");

        Field f = c.getDeclaredField("var2");     //any fields
        System.out.println("Field :------- " + f);

        Field[] fields1 = c.getFields();         // return public only
        System.out.println("Fields:----------------------------------------------- ");
        for (Field field : fields1) {
            System.out.println(field);
        }
        Field[] fields2 = c.getDeclaredFields();         // return All fields
        System.out.println("All Fields:----------------------------------------------- ");
        for (Field field : fields2) {
            System.out.println(field);
        }

        System.out.println("******************* Methods **********************\n");

        Method m = c.getDeclaredMethod("fun1", int.class);     // any methods
//        Method m = c.getDeclaredMethod("fun1", null);     // null arguments
        System.out.println("Methods :------- " + m);

        Method[] methods1 = c.getMethods();      // return public and class internal thread methods
        System.out.println("Methods:----------------------------------------------- ");
        for (Method meth : methods1) {
            System.out.println(meth);
        }

        Method[] methods2 = c.getDeclaredMethods();      // return All methods
        System.out.println("Methods:----------------------------------------------- ");
        for (Method meth : methods2) {
            System.out.println(meth);
        }

        Object obj = c.newInstance();       // return new object


    }
}
