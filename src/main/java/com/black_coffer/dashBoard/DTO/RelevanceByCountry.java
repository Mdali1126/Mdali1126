package com.black_coffer.dashBoard.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RelevanceByCountry {

    @JsonProperty("relevance")
    private Integer relevance;

    @JsonProperty("country")
    private String country;

    public RelevanceByCountry(Integer relevance, String country){
        this.relevance = relevance;
        this.country = country;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
