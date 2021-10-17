package sax;

import org.xml.sax.SAXException;
import sax.model.Noticia;

import lombok.NonNull;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SAXController {
    private static SAXController controller;
    private final String uri;
    private List<Noticia> newsList;

    public SAXController(String uri) {
        this.uri = uri;
    }

    public static SAXController getInstance(@NonNull String uri) {
        if (controller == null)
            controller = new SAXController(uri);
        return controller;
    }

    public void loadData() throws ParserConfigurationException, IOException, SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        NewsHandler handler = new NewsHandler();

        saxParser.parse(this.uri, handler);

        this.newsList = handler.getNews();
    }

    public List<Noticia> getNews() {
        return this.newsList;
    }
}
