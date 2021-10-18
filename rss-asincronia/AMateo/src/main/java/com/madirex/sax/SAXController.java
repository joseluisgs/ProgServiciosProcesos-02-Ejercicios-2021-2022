package com.madirex.sax;

import com.madirex.sax.model.Post;
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
    private List<Post> postList;

    private SAXController(String uri) {
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
        PostHandler handler = new PostHandler();
        saxParser.parse(this.uri, handler);
        this.postList = handler.getPosts();
    }

    public List<Post> getPosts() {
        return this.postList;
    }

}