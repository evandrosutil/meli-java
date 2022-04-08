package model;

public class Cow extends Animal implements Herbivore {
    @Override
    public void eatPasture() {
        System.out.println("Eating Pasture");
    }

    @Override
    public void emitSound() {
        System.out.println("Muuuuuu");
    }
}
