package com.example;

import java.util.List;

public class Lion {
    private boolean hasMane;
    private Predator predator;

    public Lion(String sex, Predator predator) {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new IllegalArgumentException("Используйте допустимые значения пола животного - самец или самка");
        }
        this.predator = predator;
    }

    public int getKittens(int count) {
        return count;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
