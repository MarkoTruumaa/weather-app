package com.weatherapp.util;

import java.time.Instant;
import java.time.ZoneId;


public class UnixConverter {

    public static Instant getLocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        return instant.atZone(ZoneId.systemDefault()).toInstant();
    }
}
