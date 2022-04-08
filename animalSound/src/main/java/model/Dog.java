package model;

public class Dog extends Animal implements Carnivore {
    @Override
    public void eatMeat() {
        System.out.println("Eating Meat");
    }

    @Override
    public void emitSound() {
        System.out.println("Au Au");
    }
}
