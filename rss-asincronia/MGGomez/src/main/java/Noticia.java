import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Noticia {
    private String title;
    private String body;
    private String bodyopt;
    private String author;
    private String link;

}
