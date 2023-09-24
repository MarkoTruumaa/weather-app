package com.weatherapp.business;

import com.weatherapp.business.city.CitiesService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Resource
    private CitiesService citiesService;

    @Scheduled(fixedRate = 60000)
    public void activateService() {
        citiesService.getCitiesMeasurementData();
    }
}
