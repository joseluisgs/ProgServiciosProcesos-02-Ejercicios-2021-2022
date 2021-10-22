import lombok.SneakyThrows;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

public class NoticiaHilo extends Thread implements Callable {
    String ruta;

    public NoticiaHilo(String ruta) {
        this.ruta = ruta;
    }


    @Override
    public Object call() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        LectorSax handler = new LectorSax();
        saxParser.parse(ruta, handler);
        List<Noticia> noticias = handler.getNoticias();
        imprimirNoticia(noticias);
        return null;
    }

    private void imprimirNoticia(List<Noticia> noticias) {
        double initTime = System.currentTimeMillis();
        for (Noticia noticia : noticias) {
            System.out.println(noticia.getTitle());

            if (noticia.getBody() != null) {
                System.out.println("\t\t" + noticia.getBody());
            }

            if (noticia.getBodyopt() != null) {
                System.out.println("\t" + noticia.getBodyopt());
            }

            System.out.println("\t\t-Autor-Autores: " + noticia.getAuthor());
            System.out.println("\t\t\t- Para más información, consulata el link de la publicación: " + noticia.getLink());
            System.out.println("\n\n");
        }
        System.out.println("Este hilo ha tardado " + (System.currentTimeMillis()- initTime) / 1000 + " seg en terminar");
    }

}
