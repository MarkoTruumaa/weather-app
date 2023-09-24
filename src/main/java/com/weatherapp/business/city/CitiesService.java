package com.weatherapp.business.city;

import com.weatherapp.business.data.DataService;
import com.weatherapp.business.Status;
import com.weatherapp.business.city.dto.CityInfo;
import com.weatherapp.business.data.dto.CurrentWeather;
import com.weatherapp.business.data.dto.WeatherData;
import com.weatherapp.domain.city.City;
import com.weatherapp.domain.city.CityMapper;
import com.weatherapp.domain.city.CityService;
import com.weatherapp.domain.citymeasurement.CityMeasurement;
import com.weatherapp.domain.citymeasurement.CityMeasurementService;
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
    @Resource
    private CityMeasurementService cityMeasurementService;


    public void addCityToDatabase(String cityName) {
        cityService.isCityInDatabaseAndActive(cityName);
        checkAndUpdateCityWithDeletedStatus(cityName);
        CityInfo cityInfo = dataService.getCityData(cityName);
        City city = cityMapper.toCity(cityInfo);
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

    public void getCitiesMeasurementData() {
        List<City> allActiveCities = cityService.findAllActiveCities();
        for (City city : allActiveCities) {
            WeatherData weatherData = dataService.getWeatherMeasurementData(city);

            CurrentWeather currentWeather = weatherData.getCurrentWeather();
            Measurement measurement = measurementMapper.toMeasurement(currentWeather);
            Instant localDateTime = UnixConverter.getLocalDateTime(currentWeather.getDt());
            measurement.setDateTime(localDateTime);
            measurementsService.saveMeasurementData(measurement);

            CityMeasurement cityMeasurement = new CityMeasurement();
            cityMeasurement.setMeasurement(measurement);
            cityMeasurement.setCity(city);
            cityMeasurementService.saveCityMeasurementData(cityMeasurement);

        }

    }
}
