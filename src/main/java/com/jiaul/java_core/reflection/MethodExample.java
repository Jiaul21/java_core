package com.jiaul.java_core.reflection;

import io.micrometer.observation.annotation.Observed;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class M {
    M (){}
    @Observed
    public void fun1(int a) throws RuntimeException {
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
}

public class MethodExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("com.jiaul.web_socket.reflection.M");       // package is required

        Method[] methods1 = c.getMethods();      // return public and class internal thread methods
        Method[] methods2 = c.getDeclaredMethods();      // return All methods
        Method m = c.getDeclaredMethod("fun1", int.class);     // any methods

        System.out.println("m.getName():-------"+m.getName());      // fun1
        System.out.println("m.getDeclaringClass():-------"+m.getDeclaringClass().getName());    // com.jiaul.web_socket.reflection.M
        System.out.println("m.getModifiers():-------"+ Modifier.toString(m.getModifiers()));    //public
        System.out.println("m.getParameterCount():-------"+m.getParameterCount());  // 1
        System.out.println("m.getReturnType():-------"+m.getReturnType().getName());    // void

        Class<?>[] parameter = m.getParameterTypes();
        for (Class<?> param : parameter) {
            System.out.println(param.getName() + " ");    // int
        }

        Constructor cons= c.getDeclaredConstructor();
        M obj= (M) cons.newInstance();
        Method m2 = c.getDeclaredMethod("fun3");

        m2.setAccessible(true);
        m2.invoke(obj,null);   // execute private method of obj object

        Class<?>[] exception = m.getExceptionTypes();
        for (Class<?> ex : exception) {
            System.out.println(ex.getName() + " ");    // java.lang.RuntimeException
        }

        Annotation[] annotations = m.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation + " ");   // annotations
        }
    }
}
