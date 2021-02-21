package com.softuni.exam.service.impl;

import com.softuni.exam.model.entity.Album;
import com.softuni.exam.model.entity.User;
import com.softuni.exam.model.service.AlbumServiceModel;
import com.softuni.exam.model.view.AlbumViewModel;
import com.softuni.exam.repository.AlbumRepository;
import com.softuni.exam.service.ArtistService;
import com.softuni.exam.service.AlbumService;
import com.softuni.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistService artistService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistService artistService,
                            UserService userService, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public long getTotalCopies() {
        return this.albumRepository.count() == 0
                ? 0L
                : this.albumRepository.getTotalCopies();
    }

    @Override
    public boolean add(AlbumServiceModel albumServiceModel, String userId) {
        User user = this.userService.getById(userId);
        if (user == null) return false;

        Album album = this.modelMapper.map(albumServiceModel, Album.class);
        album.setArtist(artistService.findByName(albumServiceModel.getArtist().getName().toString()));
        album.setGenre(albumServiceModel.getGenre());
        album.setAddedFrom(user);

        try {
            this.albumRepository.save(album);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<AlbumServiceModel> getAllAlbums() {

        return this.albumRepository.findAllByOrderByCopiesDesc().stream()
                .map(p -> this.modelMapper.map(p, AlbumServiceModel.class))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void deleteById(String id) {
        this.albumRepository.deleteById(id);
    }
}
