package com.weatherapp.util;

import com.weatherapp.business.WebAddress;
import com.weatherapp.domain.city.City;

public class UrlConstructor {

    private static final String API_KEY = "4de4d343e4ea3461e735076d87771765";

    public static String constructWeatherMapLocationUrl(String cityName) {

        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(WebAddress.WEATHER_MAP_URL_LOCATION.getUrl())
                .append("q=").append(cityName).append("&limit=1&appid=").append(API_KEY).toString();


    }

    public static String constructWeatherMapMeasurementsUrl(City city) {

        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(WebAddress.WEATHER_MAP_URL_MEASUREMENTS.getUrl())
                .append("lat=").append(city.getLatitude())
                .append("&lon=").append(city.getLongitude())
                .append("&units=metric")
                .append("&appid=").append(API_KEY).toString();


    }
}