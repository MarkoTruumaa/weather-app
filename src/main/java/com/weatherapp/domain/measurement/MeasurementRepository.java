package com.weatherapp.domain.measurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    @Query("select m from Measurement m where m.city.id = ?1")
    List<Measurement> findMeasurementsBy(Integer cityId);
}