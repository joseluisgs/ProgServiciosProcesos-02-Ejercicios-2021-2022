package rssReader;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JDOMController {

    private File XMLFile;

    public void domToXML(Document dom, String outputXML){
        try {
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            File xml = new File(outputXML);
            FileWriter fw = new FileWriter(xml);

            xmlOutput.output(dom,fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Fichero XML generado con éxito");
    }

    private List<Noticia> getNoticias(String uri){
        ArrayList<Noticia> noticias = new ArrayList();
        try {

            SAXBuilder sax = new SAXBuilder();
            Document dom = sax.build(new File(uri));
            Element root = dom.getRootElement();
            List<Element> listaNoticias = root.getChildren("item");

            listaNoticias.forEach(noticia -> {
                Noticia ultimaHora = new Noticia();
                List<String> categorias = new ArrayList();

                ultimaHora.setNombre(noticia.getChildText("title"));
                ultimaHora.setContenido(noticia.getChildText("content"));
                ultimaHora.setDescripcion(noticia.getChildText("description"));
                ultimaHora.setFecha(noticia.getChildText("pubDate"));
                ultimaHora.setUri(noticia.getChildText("link"));

                while (noticia.getChildText("category") != null) {
                    categorias.add(noticia.getChildText("category"));
                    noticia.removeChild("category");
                }
                ultimaHora.setCategorias(categorias);

                noticias.add(ultimaHora);
            });
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }


        return noticias;
    }

    public void leerNoticias(String uri){
        getNoticias(uri).forEach(System.out::println);
    }

}
