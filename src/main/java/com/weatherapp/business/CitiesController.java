package com.weatherapp.business;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

    @Resource
    private CitiesService citiesService;


    @PostMapping("/city")
    public void addCityForDataReceiving(@RequestParam String cityName) {
        citiesService.addCityForDataReceiving(cityName);
    }
}
