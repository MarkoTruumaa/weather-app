package com.weatherapp.domain.measurement;

import com.weatherapp.domain.city.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "measurement")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @NotNull
    @Column(name = "temperature", nullable = false, precision = 5, scale = 2)
    private BigDecimal temperature;

    @NotNull
    @Column(name = "wind_speed", nullable = false)
    private Integer windSpeed;

    @NotNull
    @Column(name = "humidity", nullable = false)
    private Integer humidity;

    @NotNull
    @Column(name = "date_time", nullable = false)
    private Instant dateTime;

}