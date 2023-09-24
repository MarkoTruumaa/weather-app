package com.weatherapp.domain.city;

import com.weatherapp.business.city.dto.CityInfo;
import com.weatherapp.business.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Status.class})
public interface CityMapper {


    @Mapping(source = "lat", target = "latitude")
    @Mapping(source = "lon", target = "longitude")
    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    City toCity(CityInfo cityInfo);


}