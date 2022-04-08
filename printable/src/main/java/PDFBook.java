import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PDFBook implements Printable {

    private String authorName;
    private String title;
    private String genre;
    private Integer NumberOfPages;

    @Override
    public void print() {
        System.out.printf(
                "Title: %s\nAuthor: %s\nGenre: %s\nNo. of Pages: %d",
                title, authorName, genre, NumberOfPages);
    }
}
