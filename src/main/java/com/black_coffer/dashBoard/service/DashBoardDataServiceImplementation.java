package com.black_coffer.dashBoard.service;

import com.black_coffer.dashBoard.DTO.*;
import com.black_coffer.dashBoard.entity.DashBoardData;
import com.black_coffer.dashBoard.repository.DashBoardRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashBoardDataServiceImplementation implements DashBoardDataService {

    private final DashBoardRepository repository;

    @Transactional
    @Override
    public void saveCSVData(MultipartFile file) throws IOException {
        List<DashBoardData> dataList = new ArrayList<>();

        try (Reader reader = new InputStreamReader(file.getInputStream());
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                DashBoardData data = new DashBoardData();

                data.setEndYear(parseInteger(csvRecord.get("end_year")));
                data.setCityLng(parseDouble(csvRecord.get("citylng")));
                data.setCityLat(parseDouble(csvRecord.get("citylat")));
                data.setIntensity(parseInteger(csvRecord.get("intensity")));
                data.setSector(truncateString(csvRecord.get("sector"), 255));
                data.setTopic(truncateString(csvRecord.get("topic"), 255));
                data.setInsight(truncateString(csvRecord.get("insight"), 255));
                data.setSwot(truncateString(csvRecord.get("swot"), 255));
                data.setUrl(truncateString(csvRecord.get("url"), 255));
                data.setRegion(truncateString(csvRecord.get("region"), 255));
                data.setStartYear(parseInteger(csvRecord.get("start_year")));
                data.setImpact(parseInteger(csvRecord.get("impact")));
                data.setAdded(truncateString(csvRecord.get("added"), 255));
                data.setPublished(truncateString(csvRecord.get("published"), 255));
                data.setCity(truncateString(csvRecord.get("city"), 255));
                data.setCountry(truncateString(csvRecord.get("country"), 255));
                data.setRelevance(parseInteger(csvRecord.get("relevance")));
                data.setPestle(truncateString(csvRecord.get("pestle"), 255));
                data.setSource(truncateString(csvRecord.get("source"), 255));
                data.setTitle(truncateString(csvRecord.get("title"), 255));
                data.setLikelihood(parseInteger(csvRecord.get("likelihood")));

                dataList.add(data);
            }
        }

        repository.saveAll(dataList);
    }

    private Integer parseInteger(String value) {
        return (value == null || value.isEmpty()) ? null : Integer.valueOf(value);
    }

    private Double parseDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private String truncateString(String value, int maxLength) {
        return (value != null && value.length() > maxLength) ? value.substring(0, maxLength) : value;
    }

    @Override
    public List<DisplayData> getAllData()
    {
        List<Integer> intensities = repository.findAllByIntensity();
        List<Integer> likelihood = repository.findByLikelihood();
        List<Integer> relevance = repository.findByRelevance();
        List<Integer> endYear = repository.findByEndYear();
        List<String> country = repository.findByCountry();
        List<String> topics = repository.findByTopic();
        List<String> region = repository.findByRegion();
        List<String> city = repository.findByCity();

        List<DisplayData> allDataList = new ArrayList<>();

        for(int i = 0; i < intensities.size(); i++)
        {
            allDataList.add(new DisplayData(intensities.get(i),likelihood.get(i),relevance.get(i), endYear.get(i), country.get(i), topics.get(i), region.get(i), city.get(i) ));
        }
        return allDataList;
    }

    @Override
    public List<Integer> findAllByIntensity() {
        return repository.findAllByIntensity();
    }

    @Override
    public List<Integer> findByLikelihood() {
        return repository.findByLikelihood();
    }

    @Override
    public List<Integer> findByRelevance() {

        return repository.findByRelevance();
    }

    @Override
    public List<Integer> findByStartYear() {
        return repository.findByStartYear();
    }

    @Override
    public List<Integer> findByEndYear() {
        return repository.findByEndYear();
    }

    @Override
    public List<Integer> findByYear() {
        List<Integer> dataByStartYear = repository.findByStartYear();
        List<Integer> dataByEndYear = repository.findByEndYear();

        List<Integer> combinedData = new ArrayList<>();
        combinedData.addAll(dataByStartYear);
        combinedData.addAll(dataByEndYear);

        return combinedData;
    }

    @Override
    public List<String> findByCountry() {
        return repository.findByCountry();
    }


    @Override
    public List<String> findByTopic() {
        return repository.findByTopic();
    }

    @Override
    public List<String> findByRegion() {
        return repository.findByRegion();
    }

    @Override
    public List<String> findByCity() {
        return repository.findByCity();
    }

    @Override
    public List<IntensityByRegion> findIntensityByRegion() {
        List<Integer> intensities = repository.findAllByIntensity();
        List<String> regions = repository.findByRegion();

        List<IntensityByRegion> intensityRegionList = new ArrayList<>();

        // Assuming the size of both lists are the same and correspond to each other
        for (int i = 0; i < intensities.size(); i++) {
            intensityRegionList.add(new IntensityByRegion(intensities.get(i), regions.get(i)));
        }

        return intensityRegionList;
    }

    @Override
    public List<IntensityVsLikelihood> findByIntensityVsLikelihood(){
        List<Integer> intensities = repository.findAllByIntensity();
        List<Integer> likelihood = repository.findByLikelihood();

        List<IntensityVsLikelihood> intensityLikelihoodList = new ArrayList<>();

        for (int i = 0;i < intensities.size();i++){
            intensityLikelihoodList.add(new IntensityVsLikelihood(intensities.get(i), likelihood.get(i)));
        }
        return intensityLikelihoodList;
    }

    @Override
    public List<RelevanceByCountry> findRelevanceByCountry() {
        List<Integer> relevance = repository.findByRelevance();
        List<String> country = repository.findByCountry();

        List<RelevanceByCountry> relevanceByCountryList = new ArrayList<>();

        for(int i = 0; i < relevance.size(); i++)
        {
            relevanceByCountryList.add(new RelevanceByCountry(relevance.get(i), country.get(i)));
        }
        return relevanceByCountryList;
    }

    @Override
    public List<IntensityOverYears> findIntensityOverYears() {
        List<Integer> intensities = repository.findAllByIntensity();
        List<Integer> dataByStartYear = repository.findByStartYear();


        List<IntensityOverYears> intensityYearsList = new ArrayList<>();



        for (int i = 0; i < intensities.size(); i++) {
            intensityYearsList.add(new IntensityOverYears(intensities.get(i), dataByStartYear.get(i)));
        }

        return intensityYearsList;  // Return the populated list
    }

    @Override
    public List<TopicsByCountry> findTopicsByCountry() {
        List<String> topics = repository.findByTopic();
        List<String> country = repository.findByCountry();

        List<TopicsByCountry> topicsByCountryList = new ArrayList<>();

        for(int i = 0; i < topics.size(); i++)
        {
            topicsByCountryList.add(new TopicsByCountry(topics.get(i),country.get(i)));
        }
        return topicsByCountryList;
    }

    @Override
    public List<IntensityByCity> findIntensityByCity() {

        List<Integer> intensities = repository.findAllByIntensity();
        List<String> city = repository.findByCity();

        List<IntensityByCity> intensityCityList = new ArrayList<>();

        for(int i = 0; i < intensities.size(); i++)
        {
            intensityCityList.add(new IntensityByCity(intensities.get(i),city.get(i)));
        }

        return intensityCityList;
    }
}
