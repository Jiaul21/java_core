package com.jiaul.java_core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;



class Y {

}

class X extends Y{

    public int var;

    X(int a, int b, String c) {
        System.out.println("constructor A default");
        var=a;
    }

    public X(int a) {
        System.out.println("constructor A public");
    }

    protected X(int a, int b) {
        System.out.println("constructor A default");
    }

    private X() {
        System.out.println("constructor A default");
    }
}

public class ConstructorExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class c= Class.forName("com.jiaul.web_socket.reflection.X");

        Constructor[] constructors=c.getDeclaredConstructors();     // return all constructors

        Constructor cons= c.getDeclaredConstructor(int.class,int.class,String.class);

        System.out.println("cons.getName():-------"+cons.getName());        // com.jiaul.web_socket.reflection.X
        System.out.println("cons.getDeclaringClass():-------"+cons.getDeclaringClass());        // class com.jiaul.web_socket.reflection.X
        System.out.println("cons.getModifiers():-------"+ Modifier.toString(cons.getModifiers()));      // null for default

        Class<?>[] parameter = cons.getParameterTypes();
        for (Class<?> param : parameter) {
            System.out.print(param.getName() + " ");        // int int java.lang.String
        }

        X x= (X) cons.newInstance(10,120,"value");
        System.out.println("x.var: "+x.var);        //10 value of var for x object

        Constructor cons2= c.getDeclaredConstructor();      // get default constructor
        cons2.setAccessible(true);      // making private constructor accessible

        X x2= (X) cons2.newInstance();  // creating object using private constructor

    }
}
