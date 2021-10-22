import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class LectorSax extends DefaultHandler {
    private boolean title;
    private boolean body;
    private boolean bodyopt;

    private boolean author;
    private boolean link;

    private Noticia currentNoticia = new Noticia();
    private List<Noticia> noticias = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals(DatosXml.noticiasElement.TITLE.getName())) {
            title = true;
        }
        if (qName.equals(DatosXml.noticiasElement.BODY.getName())) {
            body = true;
        }
        if (qName.equals(DatosXml.noticiasElement.BODYOPT.getName())) {
            bodyopt = true;
        }

        if (qName.equals(DatosXml.noticiasElement.AUTHOR.getName())) {
            author = true;
        }
        if (qName.equals(DatosXml.noticiasElement.LINK.getName())) {
            link = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (title) {
            currentNoticia.setTitle(new String(ch, start, length));
            title = false;
        }
        if (body) {
            currentNoticia.setBody(new String(ch, start, length));
            body = false;
        }
        if (bodyopt) {
            currentNoticia.setBodyopt(new String(ch, start, length));
            bodyopt = false;
        }
        if (author) {
            currentNoticia.setAuthor(new String(ch, start, length));
            author = false;
        }
        if (link) {
            currentNoticia.setLink(new String(ch, start, length));
            link = false;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(DatosXml.noticiasElement.ITEM.getName())) {
            noticias.add(currentNoticia);
            currentNoticia = new Noticia();
        }
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }
}
