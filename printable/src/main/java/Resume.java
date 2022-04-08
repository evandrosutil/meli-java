import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Resume implements Printable {

    private Person person;
    private List<PersonalSkills> personalSkills;

    @Override
    public void print() {
        System.out.println("Personal Info:\n------------\n"
                .concat(person.toString())
                .concat("\n\nPersonal Skills:\n------------"));
        personalSkills.forEach(System.out::println);
    }
}
