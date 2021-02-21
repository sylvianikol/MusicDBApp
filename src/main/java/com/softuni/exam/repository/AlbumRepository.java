package com.softuni.exam.repository;

import com.softuni.exam.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {

    @Query("SELECT sum(a.copies) FROM Album a ")
    long getTotalCopies();

    List<Album> findAllByOrderByCopiesDesc();
}
