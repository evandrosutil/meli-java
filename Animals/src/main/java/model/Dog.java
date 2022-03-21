package model;

import interfaces.Carnivore;

public class Dog extends Animal implements Carnivore {
    @Override
    public void emitSound() {
        System.out.println("Au");
    }

    @Override
    public void eatMeat() {
        System.out.println("Eating some meat.");
    }
}
