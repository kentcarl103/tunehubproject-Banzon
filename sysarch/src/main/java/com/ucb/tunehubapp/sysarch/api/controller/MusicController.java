package com.ucb.tunehubapp.sysarch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucb.tunehubapp.sysarch.api.model.Music;
import com.ucb.tunehubapp.sysarch.repository.MusicRepository;
import com.ucb.tunehubapp.sysarch.service.MusicService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private MusicService musicService;

    @GetMapping("/getAllMusic")
    public List<Music> getAllMusic(){
        return musicRepository.findAll();
    }

    @PostMapping("/addingMusic")
        public String AddingMusic(@RequestBody AddMusicRequest request) {
            String title = request.getTitle();
            String artist = request.getArtist();
            String urlLink = request.getUrlLink();
    
            return musicService.addingMusic(title, artist, urlLink);
        }
        
    static class AddMusicRequest {
        private String title;
        private String artist;
        private String urlLink;

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public String getUrlLink() {
            return urlLink;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public void setUrlLink(String urlLink) {
            this.urlLink = urlLink;
        }

    }

}
