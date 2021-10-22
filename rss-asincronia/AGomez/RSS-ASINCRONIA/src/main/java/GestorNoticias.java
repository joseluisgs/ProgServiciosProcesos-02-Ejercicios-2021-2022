import model.Noticia;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class GestorNoticias extends DefaultHandler {

    private boolean nItem = false;
    private boolean nTitulo = false;
    private boolean nLink = false;
    private boolean nCreador = false;
    private boolean nDescripcion = false;
    private boolean nFechaPublicacion = false;
    private List<Noticia> listaNoticias = null;
    private Noticia noticia = null;

    public List<Noticia> getNoticias() {
        return listaNoticias;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (listaNoticias == null)
            listaNoticias = new ArrayList<>();

        if (qName.equalsIgnoreCase("item")) {
            nItem = true;
            noticia = new Noticia();

        } else if (qName.equalsIgnoreCase("title")) {
            nTitulo = true;

        } else if (qName.equalsIgnoreCase("link")) {
            nLink = true;

        } else if (qName.equalsIgnoreCase("dc:creator")) {
            nCreador = true;

        } else if (qName.equalsIgnoreCase("description")) {
            nDescripcion = true;

        } else if (qName.equalsIgnoreCase("pubDate")) {
            nFechaPublicacion = true;

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {

            listaNoticias.add(noticia);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {


        if (nItem) {

            if (nTitulo) {
                noticia.setTitulo(new String(ch, start, length));
                nTitulo = false;
            } else if (nLink) {
                noticia.setLink(new String(ch, start, length));
                nLink = false;
            } else if (nCreador) {
                noticia.setCreador(new String(ch, start, length));
                nCreador = false;
            } else if (nDescripcion) {
                noticia.setDescripcion(new String(ch, start, length));
                nDescripcion = false;
            } else if (nFechaPublicacion) {
                noticia.setFechaPublicacion(new String(ch, start, length));
                nFechaPublicacion = false;
            }
        }
    }

}
