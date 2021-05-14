package com.training.spring.vanilla2.animals;

public class Zebra {
    private String name;

    public void sound () {
        System.out.println("Zebra " + name + " ihaaa");
    }

    @Override
    public String toString() {
        return "Zebra{" +
                "name='" + name + '\'' +
                '}';
    }
}
