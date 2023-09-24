package com.weatherapp.domain.measurement;

import com.weatherapp.business.data.dto.CurrentWeather;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeasurementMapper {


    @Mapping(source = "temp", target = "temperature")
    Measurement toMeasurement(CurrentWeather currentWeather);


}