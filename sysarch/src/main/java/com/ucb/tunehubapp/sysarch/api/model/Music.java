package com.ucb.tunehubapp.sysarch.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Music") // Specify the MongoDB collection name
public class Music {

    @Id // Assuming you have an ID field for MongoDB
    private String id;

    private String title;
    private String artist;
    private String urlLink;

    public Music() {
        // Empty constructor needed for Spring Data
    }

    public Music(String title, String artist, String urlLink) {
        this.title = title;
        this.artist = artist;
        this.urlLink = urlLink;
    }

    // Getters and setters


    public void setId(String id) {
        this.id = id;
    }

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

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }
}