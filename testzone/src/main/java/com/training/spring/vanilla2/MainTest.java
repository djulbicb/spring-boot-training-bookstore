package com.training.spring.vanilla2;

import com.training.spring.vanilla2.animals.VanillaComponent;
import com.training.spring.vanilla2.animals.Zoo;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class MainTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections("com.training.spring.vanilla2.animals");
        Set<Class<?>> components = reflections.getTypesAnnotatedWith(VanillaComponent.class);

        SpringContainer container = new SpringContainer();

        for (Class<?> component : components) {
            System.out.println(component);

            Object instance = component.newInstance();
            container.registerComponent(instance);
        }

        Zoo zoo = new Zoo();
        container.autowire(zoo);

        zoo.makeSounds();
    }
}
