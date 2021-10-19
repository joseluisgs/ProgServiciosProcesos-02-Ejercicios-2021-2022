package rssReader;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RssToDom {

    public Document rssReader(String uri){
        SAXBuilder builder = new SAXBuilder();
        Document dom=null;
/*
        try {
            File rss=File.createTempFile("rss","xml");
            List<String> rssList = Files.readAllLines(Path.of(uri));
            FileWriter writer = new FileWriter(rss);

            for (int i=0;i<rssList.size();i++){
                writer.write(rssList.get(i));
            }

            dom = (Document) builder.build(rss);

        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }*/

        try {
            dom = builder.build(uri);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        return dom;
    }
}
