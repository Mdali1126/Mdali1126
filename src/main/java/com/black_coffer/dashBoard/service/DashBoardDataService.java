package com.black_coffer.dashBoard.service;

import com.black_coffer.dashBoard.DTO.*;
import com.black_coffer.dashBoard.entity.DashBoardData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DashBoardDataService {

    void saveCSVData(MultipartFile file) throws IOException;

    List<DisplayData> getAllData();

    List<Integer> findAllByIntensity();

    List<Integer> findByLikelihood();

    List<Integer> findByRelevance();

    List<Integer> findByStartYear();

    List<Integer> findByEndYear();

    List<Integer> findByYear();

    List<String> findByCountry();

    List<String> findByTopic();

    List<String> findByRegion();

    List<String> findByCity();

    List<IntensityByRegion> findIntensityByRegion();

    List<IntensityVsLikelihood> findByIntensityVsLikelihood();

    List<RelevanceByCountry> findRelevanceByCountry();

    List<IntensityOverYears> findIntensityOverYears();

    List<TopicsByCountry> findTopicsByCountry();

    List<IntensityByCity> findIntensityByCity();


}
