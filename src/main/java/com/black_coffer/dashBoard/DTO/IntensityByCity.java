package com.black_coffer.dashBoard.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class IntensityByCity {

    @JsonProperty("intensity")
    private Integer intensity;
    @JsonProperty("city")
    private String city;

    public IntensityByCity(Integer intensity, String city){
        this.intensity= intensity;
        this.city= city;

    }
}
