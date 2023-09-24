package com.weatherapp.domain.city;

import com.weatherapp.domain.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select (count(c) > 0) from City c where upper(c.name) = upper(?1) and c.status = ?2")
    boolean cityExistsBy(String cityName, String status);

    @Query("select c from City c where upper(c.name) = upper(?1) and c.status = ?2")
     Optional<City> findCityBy(String cityName, String status);

    @Query("select c from City c where c.status = ?1")
    List<City> findAllBy(String status);


}