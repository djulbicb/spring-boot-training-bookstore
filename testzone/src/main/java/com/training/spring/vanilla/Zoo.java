package com.training.spring.vanilla;

class Zoo {
    String name;
    Lion lion;
    Zebra zebra;

    public Lion getLion() {
        return lion;
    }

    public void setLion(Lion lion) {
        this.lion = lion;
    }

    public Zebra getZebra() {
        return zebra;
    }

    public void setZebra(Zebra zebra) {
        this.zebra = zebra;
    }

    public void makeSounds () {
        lion.sound();
        zebra.sound();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
