package com.madirex.sax;

import com.madirex.sax.model.Post;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PostHandler extends DefaultHandler {
    private boolean hasPubDate = false;
    private boolean hasGuid = false;
    private boolean hasTitle = false;
    private boolean hasDescription = false;
    private boolean hasLink = false;
    private boolean hasCreator = false;
    private boolean hasAlternative = false;
    private boolean hasEncoded = false;

    private List<Post> postList = null;
    private Post post = null;

    private boolean enEntry = false;

    public List<Post> getPosts() {
        return postList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            enEntry = true;
        }

        // Iniciar lista
        if (postList == null) {
            postList = new ArrayList<>();
        }

        if (enEntry) {
            if (qName.equalsIgnoreCase("item")) {
                post = new Post();
            } else if (qName.equalsIgnoreCase("pubDate")) {
                hasPubDate = true;
            } else if (qName.equalsIgnoreCase("guid")) {
                hasGuid = true;
            } else if (qName.equalsIgnoreCase("title")) {
                hasTitle = true;
            } else if (qName.equalsIgnoreCase("description")) {
                hasDescription = true;
            } else if (qName.equalsIgnoreCase("link")) {
                hasLink = true;
            } else if (qName.equalsIgnoreCase("dc:creator")) {
                hasCreator = true;
            } else if (qName.equalsIgnoreCase("dcterms:alternative")) {
                hasAlternative = true;
            } else if (qName.equalsIgnoreCase("content:encoded")) {
                hasEncoded = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            postList.add(post);
            enEntry = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (hasPubDate) {
            post.setPubDate(new String(ch, start, length));
            hasPubDate = false;
        } else if (hasGuid) {
            post.setGuid(new String(ch, start, length));
            hasGuid = false;
        } else if (hasTitle) {
            post.setTitle(new String(ch, start, length));
            hasTitle = false;
        } else if (hasDescription) {
            post.setDescription(new String(ch, start, length));
            hasDescription = false;
        } else if (hasLink) {
            post.setLink(new String(ch, start, length));
            hasLink = false;
        } else if (hasCreator) {
            post.setCreator(new String(ch, start, length));
            hasCreator = false;
        } else if (hasAlternative) {
            post.setAlternative(new String(ch, start, length));
            hasAlternative = false;
        } else if (hasEncoded) {
            post.setEncoded(new String(ch, start, length));
            hasEncoded = false;
        }
    }
}