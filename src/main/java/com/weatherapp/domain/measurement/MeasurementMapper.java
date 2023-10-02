package com.weatherapp.domain.measurement;

import com.weatherapp.business.city.dto.CityMeasurementData;
import com.weatherapp.business.data.dto.Main;
import org.mapstruct.*;

import java.time.LocalTime;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {LocalTime.class})
public interface MeasurementMapper {


    @Mapping(source = "temp", target = "temperature")
    @Mapping(expression = "java(LocalTime.now())", target = "time")
    Measurement toMeasurement(Main main);


    CityMeasurementData toCityMeasurementData(Measurement measurement);

    List<CityMeasurementData> toCityMeasurementsData(List<Measurement> measurements);
}