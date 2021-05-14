package com.training.spring.javadefault;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        // Makes null exception by itself
//        Zoo zoo = new Zoo();
//        zoo.makeSounds();

        Lion lion = new Lion();
        Zebra zebra = new Zebra();
        zebra.setName("Black");
        Zebra zebra1 = new Zebra();
        zebra1.setName("Yellow");

        Zoo zoo = new Zoo();
        zoo.setLion(lion);
        zoo.setZebra(zebra);
        zoo.makeSounds();

        // Reflection
        System.out.println("- Names of fields");
        for (Field field : zoo.getClass().getDeclaredFields()) {
            System.out.println(field.getName() + " " + field.getType());
        }

        System.out.println("- Names of methods");
        for (Method method : zoo.getClass().getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        // https://stackoverflow.com/questions/22929486/using-reflection-to-invoke-method-on-field
        System.out.println("- Testing reflection");
        Method method = zoo.getClass().getMethod("makeSounds");
        method.invoke(zoo);

        // More specific
        System.out.println("----");
        Method zMethod = Zebra.class.getMethod("sound");
        Field zField = zoo.getClass().getDeclaredField("zebra");

        Object o = zField.get(zoo);
        zMethod.invoke(o);

    }
}
