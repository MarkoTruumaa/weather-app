package com.weatherapp.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;


public class UnixConverter {

    public static LocalTime getLocalTime(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        ZoneId customZone = ZoneId.of("Etc/GMT+2");
        LocalDateTime localDateTime = instant.atZone(customZone).toLocalDateTime();
        return localDateTime.toLocalTime();
    }
}
