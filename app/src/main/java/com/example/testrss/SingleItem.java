package com.example.testrss;

public class SingleItem {
    public SingleItem(String _pubDate, String _title, String _description, String _link) {
        pubDate = _pubDate;
        title = _title;
        description = _description;
        link = _link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    private String pubDate;
    private String title;
    private String description;
    private String link;

    @Override
    public String toString(){
        return title;
    }
}
