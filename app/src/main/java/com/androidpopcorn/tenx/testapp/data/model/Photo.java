package com.androidpopcorn.tenx.testapp.data.model;

public class Photo {
    private String format;
    private float width;
    private float height;
    private String filename;
    private float id;
    private String author;
    private String author_url;
    private String post_url;


    // Getter Methods

    public String getFormat() {
        return format;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getFilename() {
        return filename;
    }

    public float getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public String getPost_url() {
        return post_url;
    }

    // Setter Methods

    public void setFormat(String format) {
        this.format = format;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public void setPost_url(String post_url) {
        this.post_url = post_url;
    }
}