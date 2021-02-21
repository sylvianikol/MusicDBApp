package com.softuni.exam.repository;

import com.softuni.exam.model.entity.Artist;
import com.softuni.exam.model.enums.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {
    Optional<Artist> findByName(String name);
}
