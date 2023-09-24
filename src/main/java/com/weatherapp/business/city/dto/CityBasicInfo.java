package com.weatherapp.business.city.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.weatherapp.domain.city.City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityBasicInfo implements Serializable {

    private Integer cityId;
    @NotNull
    @Size(max = 255)
    private String cityName;
}