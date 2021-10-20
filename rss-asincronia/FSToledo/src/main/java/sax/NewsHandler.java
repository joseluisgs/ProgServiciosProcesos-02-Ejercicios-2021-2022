package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import sax.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsHandler extends DefaultHandler {
    private boolean hasItem = false;
    private boolean hasTitle = false;
    private boolean hasDescription = false;
    private boolean hasLink = false;
    private boolean hasPubDate = false;

    private List<News> newsList = null;
    private News news = null;

    public List<News> getNews(){
        return newsList;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (newsList == null)
            newsList = new ArrayList<>();
        if(qName.equalsIgnoreCase("item")){
            news = new News();
            hasItem = true;
        }
        if(hasItem){
            if (qName.equalsIgnoreCase("title")) hasTitle = true;
            else if (qName.equalsIgnoreCase("description")) hasDescription = true;
            else if (qName.equalsIgnoreCase("link")) hasLink = true;
            else if (qName.equalsIgnoreCase("pubDate")) hasPubDate = true;
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("item"))newsList.add(news);
    }
    @Override
    public void characters(char ch[], int start, int length)throws SAXException{
        if(hasTitle){
            news.setTitle(new String(ch,start,length));
            hasTitle = false;
        }else if(hasDescription){
            news.setDescription(new String(ch,start,length));
            hasDescription = false;
        }else if(hasLink){
            news.setLink(new String(ch,start,length));
            hasLink = false;
        }else if(hasPubDate){
            news.setPubDate(new String(ch,start,length));
            hasPubDate = false;
        }
    }
}
