package com.black_coffer.dashBoard.DTO;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class IntensityVsLikelihood {

    private Integer intensity;
    private Integer likelihood;


    public IntensityVsLikelihood(Integer intensity, Integer likelihood){
        this.intensity=intensity;
        this.likelihood=likelihood;
    }
}