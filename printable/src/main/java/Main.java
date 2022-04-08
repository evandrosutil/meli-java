import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void Print(Printable p) {
        p.print();
    }

    public static void main(String[] args) {

        Person jose = new Person("Jose", "Gomes", 32);
        List<PersonalSkills> joseSkills = new ArrayList<>(List.of(
                new PersonalSkills("Cooking", "knows how to boil an egg"),
                new PersonalSkills("Fishing", "can catch a fish")));
        Resume joseResume = new Resume(jose, joseSkills);

        PDFBook effectiveJava = new PDFBook("Joshua Bloch", "Effective Java", "Java Programming", 416);

        Report someReport = new Report("José Maria", "Maria José", "This is a report about something.");

        System.out.println("Printing a resume:");
        Print(joseResume);

        System.out.println("\n\nPrinting a PDF Book:");
        Print(effectiveJava);

        System.out.println("\n\nPrinting a report:");
        Print(someReport);
    }
}