package com.black_coffer.dashBoard.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class IntensityByRegion{

    @JsonProperty("intensity")
    private Integer intensity;

    @JsonProperty("region")
    private String region;



    public IntensityByRegion(Integer intensity, String region) {
        this.intensity = intensity;
        this.region = region;
    }


}
