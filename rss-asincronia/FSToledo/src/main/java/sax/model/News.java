package sax.model;

public class News {
    private String title;
    private String description;
    private String link;
    private String pubDate;

    public News() {
    }

    public News(int id, String title, String description, String link, String pubDate) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return  "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Link: " + link + "\n" +
                "PubDate:" + pubDate + "\n";
    }
}
