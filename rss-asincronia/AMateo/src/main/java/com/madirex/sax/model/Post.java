package com.madirex.sax.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String pubDate;
    private String guid;
    private String title;
    private String description;
    private String link;
    private String creator; //dc:creator
    private String alternative; //dcterms:alternative
    private String encoded; //content:encoded

    @Override
    public String toString() {
        return "\nPost:\n" +
                "   pubDate=" + pubDate + "\n" +
                "   guid=" + guid + "\n" +
                "   title=" + title + "\n" +
                "   description=" + description + "\n" +
                "   link=" + link + "\n" +
                "   creator=" + creator + "\n" +
                "   alternative=" + alternative + "\n" +
                "   encoded=" + encoded + "\n";

    }
}


