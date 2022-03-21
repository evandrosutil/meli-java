import model.Cat;
import model.Cow;
import model.Dog;

public class Main {

    public static void main(String[] args) {
        Cat pauloAfonso = new Cat();
        pauloAfonso.emitSound();
        pauloAfonso.eatMeat();

        Cow mariaAntonia = new Cow();
        mariaAntonia.emitSound();
        mariaAntonia.eatPasture();

        Dog anaPaula = new Dog();
        anaPaula.emitSound();
        anaPaula.eatMeat();
    }
}
