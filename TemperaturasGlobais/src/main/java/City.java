import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private String name;
    private Integer lowestTemp;
    private Integer highestTemp;

    @Override
    public String toString() {
        return String.format("%s: %d - %d\n", name, lowestTemp, highestTemp);
    }
}
