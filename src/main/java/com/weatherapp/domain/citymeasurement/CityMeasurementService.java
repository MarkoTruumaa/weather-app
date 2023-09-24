package com.weatherapp.domain.citymeasurement;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CityMeasurementService {

    @Resource
    private CityMeasurementRepository cityMeasurementRepository;

    public void saveCityMeasurementData(CityMeasurement cityMeasurement) {
        cityMeasurementRepository.save(cityMeasurement);
    }
}
