package com.weatherapp.business.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

/**
 * DTO for {@link com.weatherapp.domain.measurement.Measurement}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentWeather implements Serializable {
    @NotNull
    private BigDecimal temp;
    @NotNull
    private Integer windSpeed;
    @NotNull
    private Integer humidity;
    @NotNull
    private long dt;
    private long sunrise;
    private long sunset;
    private double feelsLike;
    private int pressure;
    private double dewPoint;
    private double uvi;
    private int clouds;
    private int visibility;
    private int windDeg;
    private double windGust;
    private Map<String, String> weather;
}