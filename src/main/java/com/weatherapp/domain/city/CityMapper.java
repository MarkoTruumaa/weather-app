package com.weatherapp.domain.city;

import com.weatherapp.business.city.dto.CityBasicInfo;
import com.weatherapp.business.city.dto.CityInfo;
import com.weatherapp.business.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Status.class})
public interface CityMapper {


    @Mapping(source = "lat", target = "latitude")
    @Mapping(source = "lon", target = "longitude")
    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    City toCity(CityInfo cityInfo);

    @Mapping(source = "id", target = "cityId")
    @Mapping(source = "name", target = "cityName")
    CityBasicInfo toCityBasicInfo(City city);

    List<CityBasicInfo> toCitiesBasicInfo(List<City> cities);

}