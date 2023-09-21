package com.weatherapp.domain.citymeasurement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityMeasurementRepository extends JpaRepository<CityMeasurement, Integer> {
}