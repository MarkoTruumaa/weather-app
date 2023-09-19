package com.weatherapp.validation;

import com.weatherapp.infrastructure.exception.BusinessException;
import static com.weatherapp.validation.Error.*;

public class ValidationService {


    public static void validateCityNameUsage(boolean cityNameInuse) {
        if (cityNameInuse) {
            throw new BusinessException(
                    CITY_NAME_INUSE.getErrorMessage(),
                    CITY_NAME_INUSE.getErrorCode());
        }
    }
}
