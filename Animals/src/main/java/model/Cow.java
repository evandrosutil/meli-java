package model;

import interfaces.Herbivore;

public class Cow extends Animal implements Herbivore {
    @Override
    public void emitSound() {
        System.out.println("Mu");
    }

    @Override
    public void eatPasture() {
        System.out.println("Eating pasture.");
    }
}
