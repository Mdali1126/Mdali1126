package com.black_coffer.dashBoard.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TopicsByCountry {

    private String topics;
    private String country;

    public TopicsByCountry(String topics, String country){
        this.topics = topics;
        this.country = country;
    }
}
