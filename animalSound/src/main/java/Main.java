import model.*;

public class Main {

    public static void animalFoodOption(Animal animal) {
        if (animal instanceof Herbivore) {
            ((Herbivore) animal).eatPasture();
        } else if (animal instanceof Carnivore) {
            ((Carnivore) animal).eatMeat();
        }
    }

    public static void main(String[] args) {

        Cat michaelDouglas = new Cat();
        michaelDouglas.emitSound();
        michaelDouglas.eatMeat();

        Dog rufus = new Dog();
        rufus.emitSound();
        rufus.eatMeat();

        Cow maria = new Cow();
        maria.emitSound();
        maria.eatPasture();

        animalFoodOption(michaelDouglas);
        animalFoodOption(rufus);
        animalFoodOption(maria);
    }
}
