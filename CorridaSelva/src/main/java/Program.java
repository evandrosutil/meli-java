import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        JungleRace race = new JungleRace();

        Runner ronaldo = new Runner(Categories.MEDIO, "Ro", "Naldo", 32, "123456-7", "(11)99999-9999", "(11)88888-8888", "B+");
        Runner mariMar = new Runner(Categories.AVANCADO, "Mari", "Mar", 17, "98765432-1", "(13)11111-1111", "(13)22222-2222", "AB-");
        Runner marcella = new Runner(Categories.PEQUENO, "Mar", "Cela", 27, "48765432-3", "(23)24152-2214", "(23)34421-1234", "A-");
        Runner pauloFuso = new Runner(Categories.AVANCADO, "Paulo", "Fuso", 33, "14421432-4", "(45)41245-1444", "(45)34454-1245", "B-");
        Runner jorgeAranha = new Runner(Categories.MEDIO, "Jorge", "Aranha", 15, "1212512-2", "(47)12344-4124", "(47)21451-1251", "B+");
        Runner fernandaCapivara = new Runner(Categories.PEQUENO, "Fernanda", "Capivara", 16, "455566-2", "(11)34443-1234", "(11)34565-1221", "A+");

        // add runners
        race.addRunner(ronaldo);
        race.addRunner(mariMar);
        race.addRunner(marcella);
        race.addRunner(pauloFuso);
        race.addRunner(jorgeAranha);
        race.addRunner(fernandaCapivara);

        ronaldo.setCategory(Categories.PEQUENO);
        race.addRunner(ronaldo);

        System.out.println("\n\n-----> devolvendo a lista");
        ArrayList<Runner> runners = race.listRunners();
        runners.forEach(System.out::println);

        System.out.println("\n\n-----> deletando corredor");
        race.removeRunner(ronaldo);
        race.printRunners();
    }
}
