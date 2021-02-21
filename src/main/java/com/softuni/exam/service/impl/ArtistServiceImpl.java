package com.softuni.exam.service.impl;

import com.softuni.exam.init.CareerInfoContainer;
import com.softuni.exam.model.entity.Artist;
import com.softuni.exam.model.enums.ArtistName;
import com.softuni.exam.repository.ArtistRepository;
import com.softuni.exam.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final CareerInfoContainer careerInfoContainer;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository, CareerInfoContainer careerInfoContainer) {
        this.artistRepository = artistRepository;
        this.careerInfoContainer = careerInfoContainer;
    }

    @Override
    public void initArtists() {
        if (this.artistRepository.count() == 0) {

            Arrays.stream(ArtistName.values())
                    .forEach(artistName -> {
                        Artist artist = new Artist();
                        artist.setName(artistName.name());
                        artist.setCareerInformation(this.careerInfoContainer.getCareerInfo(artistName));
                        this.artistRepository.save(artist);
                    });
        }
    }

    @Override
    public Artist findByName(String name) {
        return this.artistRepository.findByName(name).orElse(null);
    }
}
