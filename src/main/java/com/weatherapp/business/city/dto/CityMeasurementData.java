package com.weatherapp.business.city.dto;

import com.weatherapp.domain.measurement.Measurement;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalTime;

/**
 * DTO for {@link Measurement}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityMeasurementData implements Serializable {
    @NotNull
    private BigDecimal temperature;
    @NotNull
    private Integer windSpeed;
    @NotNull
    private Integer humidity;
    @NotNull
    private LocalTime time;
}