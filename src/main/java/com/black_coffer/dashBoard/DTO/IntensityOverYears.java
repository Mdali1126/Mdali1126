package com.black_coffer.dashBoard.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class IntensityOverYears {

    private Integer intensity;
    private Integer start_year;

    public IntensityOverYears(Integer intensity, Integer start_year) {

        this.intensity = intensity;
        this.start_year = start_year;

    }


}
