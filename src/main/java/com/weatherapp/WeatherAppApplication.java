package com.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;


@SpringBootApplication
@EnableScheduling
public class WeatherAppApplication {


    public static void main(String[] args) {

        SpringApplication.run(WeatherAppApplication.class, args);
    }


}
