package com.weatherapp.business.data.dto;

import com.weatherapp.business.data.dto.CurrentWeather;
import com.weatherapp.domain.city.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData implements Serializable {

    private double lat;
    private double lon;
    private String timezone;
    private int timezoneOffset;
    private CurrentWeather currentWeather;
}