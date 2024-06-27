package com.ucb.tunehubapp.sysarch.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Music")
public class Music {

    private String title;
    private String artist;
    private String url;

    public Music() {
        // Empty constructor needed for Spring Data
    }

    public Music(String title, String artist, String url) {
        this.title = title;
        this.artist = artist;
        this.url = url;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}