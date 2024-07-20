package com.ucb.tunehubapp.sysarch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucb.tunehubapp.sysarch.api.model.Music;
import com.ucb.tunehubapp.sysarch.repository.MusicRepository;

//Service for Music
@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public String addingMusic(String title, String artist, String urlLink) {
        // Check if music with the same URL already exists
        Music existingMusic = musicRepository.findByUrlLink(urlLink); // Updated method call

        if (existingMusic != null) {
            return "Message: Music with this URL already exists. Please choose another URL.";
        }

        // Create a new Music object
        Music newMusic = new Music(title, artist, urlLink);

        // Save the music to MongoDB
        musicRepository.save(newMusic);

        return "Music added successfully.";
    }

    // Additional methods for fetching and manipulating music entities
}
