package com.training.spring.vanilla;

public class MainTest {
    public static void main(String[] args) throws IllegalAccessException {
        SpringContainer container = new SpringContainer();
        container.registerComponent(new Lion("Laff"));
        container.registerComponent(new Zebra("Zebbraa"));

        Zoo zoo = new Zoo();
        container.autowire(zoo);

        zoo.makeSounds();

    }
}
