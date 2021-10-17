package sax;

import sax.model.Noticia;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class NewsHandler extends DefaultHandler{

    private boolean hasTitle = false;
    private boolean hasLink = false;
    private boolean hasDescription = false;
    private boolean hasMedia = false;
    private boolean hasPubDate = false;
    private boolean hasCategory = false;

    private List<Noticia> newsList = null;
    private Noticia news = null;

    private boolean enEntry = false;
    public List<Noticia> getNews() {
        return newsList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")){
            enEntry = true;
        }

        if (enEntry) {
            if (newsList == null)
                newsList = new ArrayList<>();
            if (qName.equalsIgnoreCase("item")) {
                news = new Noticia();
            } else if (qName.equalsIgnoreCase("title")) {
                hasTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                hasLink = true;
            } else if (qName.equalsIgnoreCase("description")) {
                hasDescription = true;
            } else if (qName.equalsIgnoreCase("media:content") || qName.equalsIgnoreCase("enclosure")) {
                String img = attributes.getValue("url");
                news.setImagen(img);
            } else if (qName.equalsIgnoreCase("guid")) {
                hasPubDate = true;
            } else if (qName.equalsIgnoreCase("pubDate")) {
                hasPubDate = true;
            } else if (qName.equalsIgnoreCase("category")) {
                hasCategory = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            newsList.add(news);
            enEntry = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (hasTitle) {
            news.setTitulo(new String(ch, start, length));
            hasTitle = false;
        } else if (hasLink) {
          news.setLink(new String(ch, start, length));
          hasLink = false;
        } else if (hasDescription) {
            news.setDescripcion(new String(ch, start, length));
            hasDescription = false;
        } else if (hasMedia) {
            news.setImagen(new String(ch, start, length));
            hasMedia = false;
        } else if (hasPubDate) {
            news.setFecha(new String(ch, start, length));
            hasPubDate = false;
        } else if (hasCategory) {
            news.setCategoria(new String(ch, start, length));
            hasCategory = false;
        }
    }
}
