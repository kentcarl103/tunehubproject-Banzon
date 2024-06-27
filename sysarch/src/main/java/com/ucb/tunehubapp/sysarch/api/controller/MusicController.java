package com.ucb.tunehubapp.sysarch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ucb.tunehubapp.sysarch.api.model.Music;
import com.ucb.tunehubapp.sysarch.repository.MusicRepository;


@RestController
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @GetMapping("/getAllMusic")
    public List<Music> getAllMusic(){
        return musicRepository.findAll();
    }

    @GetMapping("/getMusicByTitle")
    public List<Music> getMusicByTitle(@RequestParam String title){
        return musicRepository.findByTitle(title);
    }

    @GetMapping("/getMusicByArtist")
    public List<Music> getMusicByArtist(@RequestParam String artist){
        return musicRepository.findByArtist(artist);
    }

    @GetMapping("/getMusicByUrl")
    public List<Music> getMusicByUrl(@RequestParam String url){
        return musicRepository.findByUrl(url);
    }

    @PostMapping("/addMusic")
    public String addMusic(@RequestBody Music music){
        musicRepository.save(music);
        return "Music Successfully added.";
    }
}
