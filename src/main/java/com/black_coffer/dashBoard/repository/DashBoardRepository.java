package com.black_coffer.dashBoard.repository;

import com.black_coffer.dashBoard.entity.DashBoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashBoardRepository extends JpaRepository<DashBoardData, Long> {

    @Query(value = "SELECT intensity FROM dash_board_data", nativeQuery = true)
    List<Integer> findAllByIntensity();

    @Query(value = "SELECT likelihood FROM dash_board_data", nativeQuery = true)
    List<Integer> findByLikelihood();

    @Query(value = "SELECT relevance FROM dash_board_data", nativeQuery = true)
    List<Integer> findByRelevance();

    @Query(value = "SELECT country FROM dash_board_data", nativeQuery = true)
    List<String> findByCountry();

    @Query(value = "SELECT topic FROM dash_board_data", nativeQuery = true)
    List<String> findByTopic();

    @Query(value = "SELECT region FROM dash_board_data", nativeQuery = true)
    List<String> findByRegion();

    @Query(value = "SELECT city FROM dash_board_data", nativeQuery = true)
    List<String> findByCity();

    @Query(value = "SELECT start_year FROM dash_board_data", nativeQuery = true)
    List<Integer> findByStartYear();

    @Query(value = "SELECT end_year FROM dash_board_data", nativeQuery = true)
    List<Integer> findByEndYear();
}
