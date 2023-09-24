package com.weatherapp.business.data;

import com.weatherapp.business.city.dto.CityInfo;
import com.weatherapp.business.data.dto.WeatherData;
import com.weatherapp.domain.city.City;
import com.weatherapp.infrastructure.exception.DataNotFoundException;
import com.weatherapp.util.UrlConstructor;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import static com.weatherapp.validation.Error.INFO_NOT_AVAILABLE;

@Service
public class DataService {

    @Resource
    private RestTemplate restTemplate;


    public CityInfo getCityData(String cityName) {

        String url = UrlConstructor.constructWeatherMapLocationUrl(cityName);

        try {
            List<CityInfo> citiesInfo = List.of(Objects.requireNonNull(restTemplate.getForObject(url, CityInfo[].class)));
            return citiesInfo.get(0);

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new DataNotFoundException(INFO_NOT_AVAILABLE.getErrorMessage(), INFO_NOT_AVAILABLE.getErrorCode());
        }
    }

    public WeatherData getWeatherMeasurementData(City city) {
        String url = UrlConstructor.constructWeatherMapMeasurementsUrl(city);
        return restTemplate.getForObject(url, WeatherData.class);
    }

}