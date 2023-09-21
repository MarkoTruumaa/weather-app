package com.weatherapp.domain.measurement;

import com.weatherapp.domain.measurement.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}