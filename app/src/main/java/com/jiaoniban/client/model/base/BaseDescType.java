package com.jiaoniban.client.model.base;

public class BaseDescType {
    private String title;
    private String author;
    private String date;
    private String desc;
    private String id;

    public BaseDescType(String title, String author, String date, String desc, String id) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.desc = desc;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BaseDescType{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", desc='" + desc + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
