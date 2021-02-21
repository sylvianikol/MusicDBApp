package com.softuni.exam.model.service;

import com.softuni.exam.model.enums.ArtistName;

public class ArtistServiceModel extends BaseServiceModel {

    private ArtistName name;
    private String careerInformation;

    public ArtistServiceModel() {
    }

    public ArtistName getName() {
        return name;
    }

    public void setName(ArtistName name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
