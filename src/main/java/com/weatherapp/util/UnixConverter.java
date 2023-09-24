package com.weatherapp.util;

import java.time.Instant;
import java.time.ZoneId;


public class UnixConverter {

    public static Instant getLocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        ZoneId customZone = ZoneId.of("Etc/GMT+2");
        return instant.atZone(customZone).toInstant();
    }
}
