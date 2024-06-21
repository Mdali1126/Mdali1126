package com.black_coffer.dashBoard.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DisplayData {

    @JsonProperty("intensity")
    private Integer intensity;
    @JsonProperty("likelihood")
    private Integer likelihood;
    @JsonProperty("relevance")
    private Integer relevance;
    @JsonProperty("end_year")
    private Integer end_year;
    @JsonProperty("country")
    private String country;
    @JsonProperty("topics")
    private String topics;
    @JsonProperty("region")
    private String region;
    @JsonProperty("city")
    private String city;

    public DisplayData(Integer intensity, Integer likelihood, Integer relevance, Integer end_year, String country, String topics, String region, String city){

        this.intensity = intensity;

        this.likelihood = likelihood;

        this.relevance = relevance;

        this.end_year = end_year;

        this.country = country;

        this.topics = topics;

        this.region = region;

        this.city = city;
    }


}
