import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Report implements Printable {
    private String author;
    private String proofreader;
    private String text;

    @Override
    public void print() {
        System.out.printf("Author: %s\nProofreader: %s\n\n%s", author, proofreader, text);
    }
}
