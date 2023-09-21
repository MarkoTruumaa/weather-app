package com.weatherapp.domain.city;

import com.weatherapp.domain.city.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}