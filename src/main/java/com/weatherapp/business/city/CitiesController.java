package com.weatherapp.business.city;

import com.weatherapp.domain.city.City;
import com.weatherapp.domain.measurement.CityMeasurementData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitiesController {

    @Resource
    private CitiesService citiesService;


    @GetMapping("/cities")
    public List<City> findAllCities() {
        return citiesService.findAllCities();
    }

    @GetMapping("/city")
    public List<CityMeasurementData> findCityWeatherData(@RequestParam Integer cityId) {
        return citiesService.findCityWeatherData(cityId);
    }

    @PostMapping("/city")
    public void addCity(@RequestParam String cityName) {
        citiesService.addCityToDatabase(cityName);
    }

    @DeleteMapping("/city")
    public void deleteCity(@RequestParam Integer cityId) {
        citiesService.deleteCity(cityId);
    }


}
