package com.weatherapp.validation;

import com.weatherapp.infrastructure.exception.BusinessException;
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
