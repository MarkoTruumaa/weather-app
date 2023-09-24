package com.weatherapp.business.city;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

    @Resource
    private CitiesService citiesService;


    @PostMapping("/city")
    public void addCityToDatabase(@RequestParam String cityName) {
        citiesService.addCityToDatabase(cityName);
    }
}
