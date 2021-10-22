import lombok.NonNull;
import model.Noticia;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

public class SAXController implements Callable<List<Noticia>> {
    private static SAXController controller;
    private String uri;
    private List<Noticia> listaNoticias;
    private Long tiempo;


    public SAXController(@NonNull  String uri) {
        this.uri = uri;
    }


    public void loadData() throws ParserConfigurationException, IOException, SAXException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        GestorNoticias gestor = new GestorNoticias();
        saxParser.parse(this.uri, gestor);
        this.listaNoticias = gestor.getNoticias();

    }
    public List<Noticia>getNoticias(){
        return this.listaNoticias;
    }


//metodo de callable que ejecuta de forma asincrona y devuelve el resultado.
    @Override
    public List<Noticia> call() throws Exception {
       this.tiempo = System.currentTimeMillis();
        loadData();
        this.tiempo = (System.currentTimeMillis() - this.tiempo);
        return getNoticias();

    }

    public long getTiempo(){
        return this.tiempo;
    }
}
