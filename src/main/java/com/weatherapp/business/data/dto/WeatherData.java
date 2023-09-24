package com.weatherapp.business.data.dto;

import com.weatherapp.domain.city.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * DTO for {@link City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData implements Serializable {

    private Map<String, String> coord;
    private List<Object> weather;
    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Map<String, String> rain;
    private Map<String, String> clouds;
    private Long dt;
    private Map<String, String> sys;
    private Integer timezone;
    private Long id;
    private String name;
    private Integer cod;
}