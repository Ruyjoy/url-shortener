package com.example.url_shortener.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Url {
    @Id
    private  String shorturl;
    private String originalurl;

    public Url() {
    }

    // Constructor
    public Url(String shortUrl, String originalUrl) {
        this.shorturl = shortUrl;
        this.originalurl = originalUrl;
    }

    public String getShorturl() {
        return shorturl;
    }

    public void setShorturl(String shorturl) {
        this.shorturl = shorturl;
    }

    public String getOriginalurl() {
        return originalurl;
    }

    public void setOriginalurl(String originalurl) {
        this.originalurl = originalurl;
    }
}
