package com.black_coffer.dashBoard.entity;


import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class DashBoardData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="end_year")
    private Integer endYear;
    private double cityLng;
    private double cityLat;
    private Integer intensity;
    private String sector;
    private String topic;
    private String insight;
    private String swot;
    private String url;
    private String region;
    @Column(name="start_year")
    private Integer startYear;
    @Column(name = "impact_score")
    private Integer impact;
    private String added;
    private String published;
    private String city;
    private String country;
    private Integer relevance;
    private String pestle;
    private String source;
    private String title;
    private Integer likelihood;
}
