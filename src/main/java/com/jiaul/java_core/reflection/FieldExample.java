package com.jiaul.java_core.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Person {
    @Deprecated
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
public class FieldExample {
    public static void main(String[] args) throws Exception {
        // Get the Field object for 'name' and 'age'
        Field nameField = Person.class.getDeclaredField("name");

        // 1. getName()
        System.out.println("Field Name: " + nameField.getName());

        // 2. getType()
        System.out.println("Field Type: " + nameField.getType().getName());

        // 3. getModifiers()
        int modifiers = nameField.getModifiers();
        System.out.println("Modifiers: " + Modifier.toString(modifiers));

        // 4. setAccessible(boolean flag)
        nameField.setAccessible(true); // Enable access to private field

        // 5. get(Object obj)
        Person person = new Person("Alice");
        System.out.println("Initial Name: " + nameField.get(person));

        // 6. set(Object obj, Object value)
        nameField.set(person, "Bob");
        System.out.println("Updated Name: " + nameField.get(person));

        // 7. isAccessible()
        System.out.println("Is Accessible: " + nameField.isAccessible());

        // 8. getAnnotations() - get annotations present on the field
        System.out.println("Annotations on 'name' Field: ");
        for (var annotation : nameField.getAnnotations()) {
            System.out.println(annotation);
        }
    }
}
