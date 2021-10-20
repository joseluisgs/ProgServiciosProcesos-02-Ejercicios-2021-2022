package sax;

import org.xml.sax.SAXException;
import sax.model.News;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SAXController {
    private String uri;
    private List<News> newsList;

    public SAXController(String uri) {
        this.uri = uri;
    }
    public void loadData() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();
        NewsHandler newsHandler = new NewsHandler();
        saxParser.parse(this.uri,newsHandler);
        this.newsList = newsHandler.getNews();
    }
    public List<News> getNews(){
        return this.newsList;
    }

    public String getUri() {
        return uri;
    }
}
