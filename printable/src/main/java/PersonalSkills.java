import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonalSkills {

    private String skill;
    private String skillDescription;

    @Override
    public String toString() {
        return skill.concat(": ").concat(skillDescription);
    }
}
