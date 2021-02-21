package com.softuni.exam.service;

import com.softuni.exam.model.service.AlbumServiceModel;

import java.util.List;

public interface AlbumService {

    long getTotalCopies();

    boolean add(AlbumServiceModel albumServiceModel, String userId);

    List<AlbumServiceModel> getAllAlbums();

    void deleteById(String id);
}
