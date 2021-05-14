package com.training.spring.vanilla2.animals;

public class Zoo {
    public String name;
    public Lion lion;
    public Zebra zebra;
    public Spider spider;

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
        if (lion != null) {
            lion.sound();
        }
        if (zebra != null) {
            zebra.sound();
        }
        if ( spider != null) {
            spider.sound();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
