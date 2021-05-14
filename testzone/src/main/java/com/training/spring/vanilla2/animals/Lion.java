package com.training.spring.vanilla2.animals;

@VanillaComponent
public class Lion {
    private String name;

    public void sound () {
        System.out.println("Lion " + name + " roar");
    }

    @Override
    public String toString() {
        return "Lion{" +
                "name='" + name + '\'' +
                '}';
    }
}
