package com.weatherapp.business;

import com.weatherapp.domain.CityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CitiesService {

    @Resource
    private CityService cityService;

    @Resource
    private RestTemplate restTemplate;

    public void addCityForDataReceiving(String cityName) {
        cityService.isCityInDatabaseAndActive(cityName);
    }
}
