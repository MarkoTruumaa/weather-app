package com.weatherapp.business.city;

import com.weatherapp.business.data.DataService;
import com.weatherapp.business.Status;
import com.weatherapp.business.city.dto.CityInfo;
import com.weatherapp.business.data.dto.WeatherData;
import com.weatherapp.domain.city.City;
import com.weatherapp.domain.city.CityMapper;
import com.weatherapp.domain.city.CityService;
import com.weatherapp.domain.measurement.CityMeasurementData;
import com.weatherapp.domain.measurement.Measurement;
import com.weatherapp.domain.measurement.MeasurementMapper;
import com.weatherapp.domain.measurement.MeasurementsService;
import com.weatherapp.util.UnixConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CitiesService {

    @Resource
    private CityService cityService;
    @Resource
    private DataService dataService;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private MeasurementMapper measurementMapper;
    @Resource
    private MeasurementsService measurementsService;


    public void addCityToDatabase(String cityName) {
        cityService.isCityInDatabaseAndActive(cityName);
        checkAndUpdateCityWithDeletedStatus(cityName);
        CityInfo cityInfo = dataService.getCityData(cityName);
        City city = cityMapper.toCity(cityInfo);
        cityService.saveCity(city);
    }

    public void getCitiesMeasurementData() {
        List<City> allActiveCities = cityService.findAllActiveCities();
        if (allActiveCities.isEmpty()) {
            return;
        }
        for (City city : allActiveCities) {
            WeatherData weatherData = dataService.getWeatherMeasurementData(city);
            createAndSaveCityMeasurementData(city, weatherData);

        }

    }

    public void deleteCity(Integer cityId) {
        City city = cityService.getCityBy(cityId);
        city.setStatus(Status.DELETED.getLetter());
        cityService.saveCity(city);
    }

    private void checkAndUpdateCityWithDeletedStatus(String cityName) {
        Optional<City> cityWithStatusDeleted = cityService.findCityWithStatusDeleted(cityName);
        if (cityWithStatusDeleted.isPresent()) {
            City city = cityWithStatusDeleted.get();
            city.setStatus(Status.ACTIVE.getLetter());
            cityService.saveCity(city);
        }
    }

    private void createAndSaveCityMeasurementData(City city, WeatherData weatherData) {
        Measurement measurement = measurementMapper.toMeasurement(weatherData.getMain());
        Instant localDateTime = UnixConverter.getLocalDateTime(weatherData.getDt());
        measurement.setDateTime(localDateTime);
        measurement.setWindSpeed(weatherData.getWind().getSpeed());
        measurement.setCity(city);
        measurementsService.saveCityMeasurementData(measurement);
    }

    public List<City> findAllCities() {
        return cityService.findAllActiveCities();
    }

    public List<CityMeasurementData> findCityWeatherData(Integer cityId) {
        List<Measurement> measurementsData = measurementsService.getMeasurementDataBy(cityId);
        return measurementMapper.toCityMeasurementsData(measurementsData);
    }
}
