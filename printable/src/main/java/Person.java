import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;
    private Integer age;

    @Override
    public String toString() {
        return String.format("Name: %s\nLastname: %s\nAge: %d", firstName, lastName, age);
    }
}
