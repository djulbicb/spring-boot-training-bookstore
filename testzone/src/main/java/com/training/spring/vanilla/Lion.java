package com.training.spring.vanilla;

class Lion {
    private final String name;

    public Lion(String name) {
        this.name = name;
    }

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
