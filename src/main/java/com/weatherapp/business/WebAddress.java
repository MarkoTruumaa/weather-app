package com.weatherapp.business;

import lombok.Getter;

@Getter
public enum WebAddress {

    WEATHER_MAP_URL_LOCATION("http://api.openweathermap.org/geo/1.0/direct?"),
    WEATHER_MAP_URL_MEASUREMENTS("https://api.openweathermap.org/data/2.5/weather?");

    private final String url;

    WebAddress(String url) {
        this.url = url;
    }
}
