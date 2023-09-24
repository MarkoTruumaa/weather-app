package com.weatherapp.validation;

import lombok.Getter;

@Getter
public enum Error {

    CITY_NAME_EXISTS("Antud linna nimi on juba süsteemis ja andmed kättesaadavad", 111),
    ;


    private final String errorMessage;
    private final int errorCode;

    Error(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
