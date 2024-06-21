package com.black_coffer.dashBoard.controller;

import com.black_coffer.dashBoard.DTO.*;
import com.black_coffer.dashBoard.entity.DashBoardData;
import com.black_coffer.dashBoard.service.DashBoardDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DashBoardDataController {

    private final DashBoardDataService service;

    @PostMapping("/postData")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file) {
        try {
            service.saveCSVData(file);
            return "File uploaded and data saved successfully!";
        } catch (IOException e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/intensity")
    public List<Integer> getAllDataByIntensity() {
        return service.findAllByIntensity();
    }

    @GetMapping("/likelihood")
    public List<Integer> getDataByLikelihood() {
        return service.findByLikelihood();
    }

    @GetMapping("/relevance")
    public List<Integer> getDataByRelevance() {
        return service.findByRelevance();
    }

    @GetMapping("/startYear")
    public List<Integer> getDataByStartYear() {
        return service.findByStartYear();
    }

    @GetMapping("/endYear")
    public List<Integer> getDataByEndYear() {
        return service.findByEndYear();
    }

    @GetMapping("/year")
    public List<Integer> findByYear() {
        return service.findByYear();
    }

    @GetMapping("/country")
    public List<String> getDataByCountry() {
        return service.findByCountry();
    }

    @GetMapping("/topic")
    public List<String> getDataByTopic() {
        return service.findByTopic();
    }

    @GetMapping("/region")
    public List<String> getDataByRegion() {
        return service.findByRegion();
    }

    @GetMapping("/city")
    public List<String> getDataByCity() {
        return service.findByCity();
    }

    @GetMapping("/intensityByRegion")
    public List<IntensityByRegion> getIntensityByRegion() {
        return service.findIntensityByRegion();
    }

    @GetMapping("/intensityVsLikelihood")
    public List<IntensityVsLikelihood> getIntensityVsLikelihood() {
        return service.findByIntensityVsLikelihood();
    }

    @GetMapping("/relevanceByCountry")
    public List<RelevanceByCountry> getRelevanceByCountry() {
        return service.findRelevanceByCountry();
    }

    @GetMapping("/intensityOverYears")
    public List<IntensityOverYears> getIntensityOverYears() {
        return service.findIntensityOverYears();
    }

    @GetMapping("/topicsByCountry")
    public List<TopicsByCountry> getTopicsByCountry() {
        return service.findTopicsByCountry();
    }

    @GetMapping("/intensityByCity")
    public List<IntensityByCity> getIntensityByCity() {return service.findIntensityByCity();}

    @GetMapping("/allData")
    public List<DisplayData> getAllData() {return service.getAllData();}
}

