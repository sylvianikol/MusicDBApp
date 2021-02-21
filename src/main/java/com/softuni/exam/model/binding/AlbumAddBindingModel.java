package com.softuni.exam.model.binding;

import com.softuni.exam.model.enums.ArtistName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.softuni.exam.constant.ValidationErrorMessages.*;

public class AlbumAddBindingModel {

    private String name;
    private String imgUrl;
    private BigDecimal price;
    private long copies;
    private LocalDate releaseDate;
    private String producer;
    private ArtistName artist;
    private String genre;
    private String description;

    public AlbumAddBindingModel() {
    }

    @NotBlank(message = NAME_BLANK)
    @Size(min = 3, max = 20, message = NAME_LENGTH)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = IMG_URL_BLANK)
    @Size(min = 5, message = IMG_URL_MIN)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @NotNull(message = PRICE_NULL)
    @DecimalMin(value = "0", message = PRICE_MIN)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Min(value = 10, message = COPIES_MIN)
    public long getCopies() {
        return copies;
    }

    public void setCopies(long copies) {
        this.copies = copies;
    }

    @DateTimeFormat(pattern = DATE_PATTERN)
    @NotNull(message = DATE_NULL)
    @PastOrPresent(message = DATE_PAST)
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @NotNull(message = ARTIST_NULL)
    public ArtistName getArtist() {
        return artist;
    }

    public void setArtist(ArtistName artist) {
        this.artist = artist;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @NotBlank(message = GENRE_NULL)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @NotBlank(message = DESC_BLANK)
    @Size(min = 5, message = DESC_MIN)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
