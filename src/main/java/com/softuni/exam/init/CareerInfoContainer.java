package com.softuni.exam.init;

import com.softuni.exam.model.enums.ArtistName;

import java.util.Map;

import static com.softuni.exam.constant.CareerInfoText.*;

public class CareerInfoContainer {

    private final Map<ArtistName, String> careerInfos;

    public CareerInfoContainer() {
        this.careerInfos = Map.of(
                ArtistName.MADONNA, MADONNA_INFO,
                ArtistName.METALLICA, METALLICA_INFO,
                ArtistName.QUEEN, QUEEN_INFO
        );
    }

    public String getCareerInfo(ArtistName artistName) {
        return this.careerInfos.get(artistName);
    }
}
