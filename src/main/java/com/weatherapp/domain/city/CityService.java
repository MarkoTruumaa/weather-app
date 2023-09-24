package com.weatherapp.domain.city;

import com.weatherapp.business.Status;
import com.weatherapp.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;


    public void isCityInDatabaseAndActive(String cityName) {
        boolean cityExists = cityRepository.cityExistsBy(cityName, Status.ACTIVE.getLetter());
        ValidationService.validateCityNameUsage(cityExists);
    }

    public Optional<City> findCityWithStatusDeleted(String cityName) {
        return cityRepository.findCityBy(cityName, Status.DELETED.getLetter());
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }

    public List<City> findAllActiveCities() {
        return cityRepository.findAllBy(Status.ACTIVE.getLetter());
    }

    public City getCityBy(Integer cityId) {
        return cityRepository.getReferenceById(cityId);
    }
}
