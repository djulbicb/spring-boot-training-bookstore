package com.training.spring.vanilla;

class Zebra {
    private final String name;

    public Zebra(String name) {
        this.name = name;
    }

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
