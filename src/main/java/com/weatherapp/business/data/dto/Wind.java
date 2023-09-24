package com.weatherapp.business.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.weatherapp.domain.measurement.Measurement}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind implements Serializable {
    @NotNull
    private Integer speed;
    private Integer deg;
    private Double gust;
}