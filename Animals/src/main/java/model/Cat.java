package model;

import interfaces.Carnivore;

public class Cat extends Animal implements Carnivore {
    @Override
    public void emitSound() {
        System.out.println("Meow");
    }

    @Override
    public void eatMeat() {
        System.out.println("Eating some meat.");
    }
}