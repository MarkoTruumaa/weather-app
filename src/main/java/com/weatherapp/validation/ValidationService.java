package com.weatherapp.validation;

import com.weatherapp.business.city.dto.CityInfo;
import com.weatherapp.infrastructure.exception.BusinessException;
import com.weatherapp.infrastructure.exception.DataNotFoundException;

import java.util.List;

import static com.weatherapp.validation.Error.*;

public class ValidationService {


    public static void validateCityNameUsage(boolean cityNameExists) {
        if (cityNameExists) {
            throw new BusinessException(
                    CITY_NAME_EXISTS.getErrorMessage(),
                    CITY_NAME_EXISTS.getErrorCode());
        }
    }
}
