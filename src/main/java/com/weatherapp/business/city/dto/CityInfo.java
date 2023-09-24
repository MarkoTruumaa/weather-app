package com.weatherapp.business.city.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;


/**
 * DTO for {@link com.weatherapp.domain.city.City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityInfo implements Serializable {
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    private BigDecimal lon;
    @NotNull
    private BigDecimal lat;
    @NotNull
    @Size(max = 10)
    private String country;
    @Size(max = 100)
    private String state;

    private Map<String, String> localNames;
}