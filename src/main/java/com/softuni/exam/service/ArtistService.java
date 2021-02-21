package com.softuni.exam.service;


import com.softuni.exam.model.entity.Artist;

public interface ArtistService {
    void initArtists();

    Artist findByName(String name);
}
