package com.weatherapp.business.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * DTO for {@link com.weatherapp.domain.measurement.Measurement}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main implements Serializable {
    @NotNull
    private BigDecimal temp;
    @NotNull
    private Integer humidity;
    private Double feelsLike;
    private Double tempMin;
    private Double tempMax;
    private Integer pressure;
    private Integer seaLevel;
    private Integer grndLevel;
}