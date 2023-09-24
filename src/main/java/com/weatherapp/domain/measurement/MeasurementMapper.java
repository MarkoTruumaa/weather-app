package com.weatherapp.domain.measurement;

import com.weatherapp.business.data.dto.Main;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeasurementMapper {


    @Mapping(source = "temp", target = "temperature")
    Measurement toMeasurement(Main main);


    CityMeasurementData toCityMeasurementData(Measurement measurement);

    List<CityMeasurementData> toCityMeasurementsData(List<Measurement> measurements);
}