package com.ucb.tunehubapp.sysarch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ucb.tunehubapp.sysarch.api.model.Music;

@Repository
public interface MusicRepository extends MongoRepository<Music, String> {

    List<Music> findByTitle(String title);

    List<Music> findByArtist(String artist);

    Music findByUrlLink(String urlLink);

}
