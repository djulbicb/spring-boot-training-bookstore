package com.training.spring.vanilla2.animals;

@VanillaComponent
public class Spider {
    private String name;

    public void sound () {
        System.out.println("Spider " + name + " scares");
    }

    @Override
    public String toString() {
        return "Zebra{" +
                "name='" + name + '\'' +
                '}';
    }
}
