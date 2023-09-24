package com.weatherapp.domain.measurement;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementsService {

    @Resource
    private MeasurementRepository measurementRepository;


    public void saveCityMeasurementData(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    public List<Measurement> getMeasurementDataBy(Integer cityId) {
        return measurementRepository.findMeasurementsBy(cityId);
    }
}
