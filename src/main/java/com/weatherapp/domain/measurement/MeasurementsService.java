package com.weatherapp.domain.measurement;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MeasurementsService {

    @Resource
    private MeasurementRepository measurementRepository;


    public void saveMeasurementData(Measurement measurement) {
        measurementRepository.save(measurement);
    }
}
